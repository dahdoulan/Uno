package org.example;

import java.util.Collection;
import java.util.Collections;

public interface Deck <E>{
    void initializeDeck();
    Collection<E> shuffleDeck();
    E  getCard();
}
