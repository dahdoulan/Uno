package org.example.match;

import org.example.card.Card;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class Player{
    private final String name;
    private final List<Card> hand = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public void addCard(Card card){
        if(isNull(card))
            throw(new NullPointerException("Can NOT Add card to hand, card is null."));
        hand.add(card);
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
