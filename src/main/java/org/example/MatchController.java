package org.example;

import java.util.List;
import java.util.Random;

public class MatchController {
    private final UnoDeck deck = new UnoDeck();
    private final UnoPile pile = new UnoPile();
    private final UiController uiController = new UiController();
    private static MatchController matchController;

    private Color currentColor;

    private MatchController(){
        deck.initializeDeck();
        deck.shuffleDeck();

        Card card = deck.getCard();
        pile.initializePile(card);

        currentColor = card.getColor();
    }

    public Card drawCard(){
        Card card = deck.getCard();
        uiController.displayMessage("---> "+ card.getType() + " Was Drawn ! <---");
        return card;
    }

    public Color getCurrentColor(){
        return currentColor;
    }

    public void changeColor(Color color){
        this.currentColor = color;
    }

    public boolean cardIsEligible(Card card){
        if(card == null){
            throw new NullPointerException("Can NOT check card eligibility, card is null.");
        }

        CardEligibilityVisitor visitor = new CardEligibilityVisitor(pile.getTopCard(), currentColor);
        card.accept(visitor);

        return visitor.isEligible();
    }

    public Card addCardToPile(Card card){
        if(card == null){
            throw new NullPointerException("Can NOT add card to pile, card is null.");
        }

        pile.addCard(card);
        currentColor = card.getColor();
        uiController.displayMessage("---> " + card.getType() + " Was played <---");

        return card;
    }

    public Color chooseColor(){
        Color[] color ={
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
        };
        Random rand = new Random();

        return color[rand.nextInt(4)];
    }

    public Card chooseCard(List<Card> hand){
        for(Card card : hand){
            if (cardIsEligible(card)){
                Card temp = addCardToPile(card);
                hand.remove(card);
                return temp;
            }
        }

        return null;
    }

    public static MatchController getInstance(){
        if(matchController == null){
            matchController = new MatchController();
        }

        return matchController;
    }
}
