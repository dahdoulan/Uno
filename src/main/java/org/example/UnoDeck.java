package org.example;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class UnoDeck implements Deck<Card>{
    private final Stack<Card> deck = new Stack<>();

    private void initializeWildcards() {
        for (int i = 0; i < 4; i++) {
            deck.push(new ChangeColor(Color.WILDCARD));
            deck.push(new DrawFour(Color.WILDCARD));
        }
    }

    private void initializeColorCards(Color color) {
        for (int i = 0; i < 10; i++) {
            Card card = new RegularCard(i, color);
            deck.push(card);
            if (i != 0) {
                deck.push(new RegularCard(i, color));
            }
        }
        deck.push(new SkipCard(color));
        deck.push(new ReverseCard(color));
        deck.push(new DrawTwo(color));
        deck.push(new SkipCard(color));
        deck.push(new ReverseCard(color));
        deck.push(new DrawTwo(color));
    }

    public void initializeDeck() {
        initializeColorCards(Color.RED);
        initializeColorCards(Color.GREEN);
        initializeColorCards(Color.BLUE);
        initializeColorCards(Color.YELLOW);
        initializeWildcards();
    }

    public Collection<Card> shuffleDeck() {
        Collections.shuffle(deck);
        return deck;
    }

    public Card getCard() {
        if (deck.isEmpty()) {
            initializeDeck();
            shuffleDeck();
        }
        return deck.pop();
    }
}