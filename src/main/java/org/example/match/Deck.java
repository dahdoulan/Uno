package org.example.match;

import java.util.Collection;

public interface Deck <E>{
    void initializeDeck();
    Collection<E> shuffleDeck();
    E  getCard();
}
