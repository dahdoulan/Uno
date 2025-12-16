package org.example.controllers;

import org.example.card.EmptyCard;
import org.example.core.enums.Color;
import org.example.match.UnoDeck;
import org.example.match.UnoPile;
import org.example.card.Card;
import org.example.card.visitor.CardEligibilityVisitor;

import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;

public class MatchController {

    private static final String CARD_PLAYED_FORMAT = "---> %s was played <---";
    private static final String CARD_DRAWN_FORMAT = "---> %s was drawn <---";

    private final UnoDeck deck = new UnoDeck();
    private final UnoPile pile = new UnoPile();
    private final UiController uiController = new UiController();
    private static MatchController matchController;

    private Color currentColor;

    private MatchController() {
        deck.initializeDeck();
        deck.shuffleDeck();

        Card card = deck.getCard();
        pile.initializePile(card);
        currentColor = card.getColor();
    }

    public static MatchController getInstance() {
        if (isNull(matchController))
            matchController = new MatchController();
        return matchController;
    }

    public Card playCard(Card card) {
        if (isNull(card))
            throw new NullPointerException("Cannot play card, card is null.");

        pile.addCard(card);
        currentColor = card.getColor();
        uiController.displayMessage(String.format(CARD_PLAYED_FORMAT, card.getType()));
        return card;
    }

    public Card chooseCard(List<Card> hand) {
        Iterator<Card> iterator = hand.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (isCardEligible(card)) {
                iterator.remove();
                return playCard(card);
            }
        }
        return new EmptyCard();
    }

    public Card drawCard() {
        Card card = deck.getCard();
        uiController.displayMessage(String.format(CARD_DRAWN_FORMAT, card.getType()));
        return card;
    }

    public boolean isCardEligible(Card card) {
        if (isNull(card))
            throw new NullPointerException("Cannot check card eligibility, card is null.");

        CardEligibilityVisitor visitor = new CardEligibilityVisitor(pile.getTopCard(), currentColor);
        card.accept(visitor);
        return visitor.isEligible();
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void changeColor(Color color) {
        this.currentColor = color;
    }
}
