package org.example;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<Card> deck = new Stack<>();

    public void initializeRed(){
        for (int i = 0 ; i < 9 ; i++){
            Card card = new RegularCard(
                    i,
                    Color.RED
            );

            if(card != null){
                deck.push(card);
                deck.push(card);
            }
        }
        deck.push(new SkipCard(Color.RED));
        deck.push(new ReverseCard(Color.RED));
        deck.push(new DrawTwo(Color.RED));

        deck.push(new SkipCard(Color.RED));
        deck.push(new ReverseCard(Color.RED));
        deck.push(new DrawTwo(Color.RED));
    }

    public void initializeGreen(){
        for (int i = 0 ; i < 9 ; i++){
            Card card = new RegularCard(
                    i,
                    Color.GREEN
            );

            if(card != null){
                deck.push(card);
                deck.push(card);
            }
        }
        deck.push(new SkipCard(Color.GREEN));
        deck.push(new ReverseCard(Color.GREEN));
        deck.push(new DrawTwo(Color.GREEN));

        deck.push(new SkipCard(Color.GREEN));
        deck.push(new ReverseCard(Color.GREEN));
        deck.push(new DrawTwo(Color.GREEN));
    }

    public void initializeBlue(){
        for (int i = 0 ; i < 9 ; i++){
            Card card = new RegularCard(
                    i,
                    Color.BLUE
            );

            if(card != null){
                deck.push(card);
                deck.push(card);
            }
        }
        deck.push(new SkipCard(Color.BLUE));
        deck.push(new ReverseCard(Color.BLUE));
        deck.push(new DrawTwo(Color.BLUE));

        deck.push(new SkipCard(Color.BLUE));
        deck.push(new ReverseCard(Color.BLUE));
        deck.push(new DrawTwo(Color.BLUE));
    }

    public void initializeYellow(){
        for (int i = 0 ; i < 9 ; i++){
            Card card = new RegularCard(
                    i,
                    Color.YELLOW
            );

            if(card != null){
                deck.push(card);
                deck.push(card);
            }
        }
        deck.push(new SkipCard(Color.YELLOW));
        deck.push(new ReverseCard(Color.YELLOW));
        deck.push(new DrawTwo(Color.YELLOW));

        deck.push(new SkipCard(Color.YELLOW));
        deck.push(new ReverseCard(Color.YELLOW));
        deck.push(new DrawTwo(Color.YELLOW));
    }

    public void initializeWildcards(){
        for(int i = 0; i < 4 ; i++){
            Card changeColor = new ChangeColor();
            Card drawFour = new DrawFour();

            if(changeColor != null && drawFour != null){
                deck.push(changeColor);
                deck.push(drawFour);
            }
        }
    }

    public Collection initializeDeck(){

        initializeRed();
        initializeGreen();
        initializeBlue();
        initializeYellow();
        initializeWildcards();

        return deck;
    }

    public Collection shuffleDeck() {
        // It is said in probability that a deck of cards needs 20 shuffles to achieve total randomness.
        for(int i = 0; i < 20 ; i++){
            Collections.shuffle(deck);
        }
        return deck;
    }

    public Card getCard(){
        if(deck.isEmpty()){
            initializeDeck();
        }

        return deck.pop();
    }
}
