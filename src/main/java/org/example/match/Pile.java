package org.example.match;

import org.example.cards.Card;

public interface Pile <E> {
    void addCard(Card card);

    void initializePile(Card card);

    E getTopCard();
}
