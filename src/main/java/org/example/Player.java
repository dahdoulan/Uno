package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player{
    public String name;
    private List<Card> hand = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public void addCard(Card card){
        if(card == null){
            throw(new NullPointerException("Can NOT Add card to hand, card is null."));
        }

        hand.add(card);
    }

    public void removeCard(Card card){
        if(card == null){
            throw(new NullPointerException("Can NOT remove card from hand, card is null."));
        }

        hand.remove(card);
    }

    public void getHand(){
        for(Card card : hand){
            card.printInfo();
        }
    }

    @Override
    public String toString() {
        return "Player Name: { " + name + " }";
    }
}
