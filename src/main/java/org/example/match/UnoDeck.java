package org.example.match;

import org.example.card.Card;
import org.example.card.UnoRegularCardFactory;
import org.example.card.UnoSpecialCardFactory;
import org.example.core.card.RegularCardFactory;
import org.example.core.card.SpecialCardFactory;
import org.example.core.enums.CardType;
import org.example.core.enums.Color;
import org.example.core.game.Deck;

import java.util.Stack;

import static java.util.Collections.shuffle;

public class UnoDeck implements Deck<Card> {

    private static final int NUM_OF_WILD_CARDS = 4;
    private static final int NUM_OF_REGULAR_CARDS = 10;
    private static final int NUM_OF_EACH_SPECIAL_CARD = 2;
    private static final int NUMBER_ZERO_CARD = 0;

    private final Stack<Card> deck = new Stack<>();
    private final RegularCardFactory<Card> regularCardFactory = new UnoRegularCardFactory();
    private final SpecialCardFactory<Card> specialCardFactory = new UnoSpecialCardFactory();

    public void initializeDeck() {
        initializeColorCards(Color.RED);
        initializeColorCards(Color.GREEN);
        initializeColorCards(Color.BLUE);
        initializeColorCards(Color.YELLOW);
        initializeWildcards();
    }

    public void shuffleDeck() {
        shuffle(deck);
    }

    public Card getCard() {
        if (deck.isEmpty()) {
            initializeDeck();
            shuffleDeck();
        }
        return deck.pop();
    }

    private void initializeWildcards() {
        for (int i = 0; i < NUM_OF_WILD_CARDS; i++) {
            deck.push(specialCardFactory.getInstance(CardType.ChangeColor, Color.WILDCARD));
            deck.push(specialCardFactory.getInstance(CardType.DrawFour, Color.WILDCARD));
        }
    }

    private void initializeColorCards(Color color) {
        initializeRegularCards(color);
        initializeSpecialCards(color);
    }

    private void initializeRegularCards(Color color) {
        for (int i = 0; i < NUM_OF_REGULAR_CARDS; i++) {
            deck.push(regularCardFactory.getInstance(color, i));
            if (i != NUMBER_ZERO_CARD)
                deck.push(regularCardFactory.getInstance(color, i));
        }
    }

    private void initializeSpecialCards(Color color) {
        for (int i = 0; i < NUM_OF_EACH_SPECIAL_CARD; i++) {
            deck.push(specialCardFactory.getInstance(CardType.Skip, color));
            deck.push(specialCardFactory.getInstance(CardType.Reverse, color));
            deck.push(specialCardFactory.getInstance(CardType.DrawTwo, color));
        }
    }
}