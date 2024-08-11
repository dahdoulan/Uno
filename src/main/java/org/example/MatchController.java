package org.example;

public class MatchController {

    private Deck deck = new Deck();
    private Pile pile = new Pile();

    public Card drawCard(){
        return deck.getCard();
    }

    public void initializePile(){
        Card card = deck.getCard();
        pile.initializePile(card);
    }

    public void initializeDeck(){
        deck.initializeDeck();
        deck.shuffleDeck();
    }
}
