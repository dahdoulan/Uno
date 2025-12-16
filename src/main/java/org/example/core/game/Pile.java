package org.example.core.game;

import org.example.card.Card;

public interface Pile <E> {
    void addCard(Card card);

    void initializePile(Card card);

    E getTopCard();
}
