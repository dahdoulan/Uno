package org.example.match;

import org.example.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player{
    private final String name;
    private final List<Card> hand = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public void addCard(Card card){
        if(card == null){
            throw(new NullPointerException("Can NOT Add card to hand, card is null."));
        }

        hand.add(card);
    }

    public void removeCard(int index){
        if(index < 0){
            throw(new NullPointerException("Can NOT remove card from hand, card is null."));
        }

        hand.remove(index);
    }
    public List<Card> getHand(){
        return hand;
    }
    public void printHand(){
        int index = 1;
        for(Card card : hand){
            System.out.print("( " + index++ + " ) ");
            card.printInfo();
        }
    }
    @Override
    public String toString() {
        return name;
    }
}
