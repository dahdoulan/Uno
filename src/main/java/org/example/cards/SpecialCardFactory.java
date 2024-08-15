package org.example.cards;

import org.example.enums.CardType;
import org.example.enums.Color;

public interface SpecialCardFactory <E>{
     E getInstance(CardType type, Color color);
}
