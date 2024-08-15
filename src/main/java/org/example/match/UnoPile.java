package org.example.match;

import org.example.cards.Card;

import java.util.Stack;

public class UnoPile implements Pile<Card>{
    private final Stack<Card> pile = new Stack<>();

    @Override
    public void addCard(Card card){
        if(card != null){
            pile.push(card);
        }
    }
    @Override
    public void initializePile(Card card){
        if(card == null){
            throw(new NullPointerException("Can NOT initialize pile, card is null."));
        }

        pile.push(card);
    }
    @Override
    public Card getTopCard(){
        return pile.peek();
    }
}
