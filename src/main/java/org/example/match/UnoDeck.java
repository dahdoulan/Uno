package org.example.match;

import org.example.cards.*;
import org.example.enums.CardType;
import org.example.enums.Color;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class UnoDeck implements Deck<Card>{
    private final Stack<Card> deck = new Stack<>();
    private final RegularCardFactory<Card> regularCardFactory = new UnoRegularCardFactory();
    private final SpecialCardFactory<Card> specialCardFactory = new UnoSpecialCardFactory();

    private void initializeWildcards() {
        for (int i = 0; i < 4; i++) {
            deck.push(specialCardFactory.getInstance(CardType.ChangeColor, Color.WILDCARD));
            deck.push(specialCardFactory.getInstance(CardType.DrawFour, Color.WILDCARD));
        }
    }
    private void initializeColorCards(Color color) {
        for (int i = 0; i < 10; i++) {
            Card card = regularCardFactory.getInstance(color, i);
            deck.push(card);
            if (i != 0) {
                deck.push(regularCardFactory.getInstance(color, i));
            }
        }
        deck.push(specialCardFactory.getInstance(CardType.Skip, color));
        deck.push(specialCardFactory.getInstance(CardType.Reverse, color));
        deck.push(specialCardFactory.getInstance(CardType.DrawTwo, color));
        deck.push(specialCardFactory.getInstance(CardType.Skip, color));
        deck.push(specialCardFactory.getInstance(CardType.Reverse, color));
        deck.push(specialCardFactory.getInstance(CardType.DrawTwo, color));
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