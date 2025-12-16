package org.example.core.game;

public interface Deck <E>{
    void initializeDeck();
    void shuffleDeck();
    E  getCard();
}
