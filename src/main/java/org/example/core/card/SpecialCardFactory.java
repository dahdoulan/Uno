package org.example.core.card;

import org.example.core.enums.CardType;
import org.example.core.enums.Color;

public interface SpecialCardFactory <E>{
     E getInstance(CardType type, Color color);
}
