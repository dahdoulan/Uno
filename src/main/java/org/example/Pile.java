package org.example;

import java.util.Stack;

public class Pile {
    private Color currentColor;

    private Stack<Card> pile = new Stack<>();

    public void dropCard(Card card){
        if(card != null){
            pile.push(card);
        }
    }

    public void initializePile(Card card){
        if(card == null){
            throw(new NullPointerException("Can NOT initialize pile, card is null."));
        }

        pile.push(card);
    }

    public Card getTopCard(){
        return pile.peek();
    }
}
