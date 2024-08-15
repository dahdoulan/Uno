package org.example;

public interface Pile <E> {
    void addCard(Card card);

    void initializePile(Card card);

    E getTopCard();
}
