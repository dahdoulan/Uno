package org.example.cards;

import org.example.enums.Color;

public interface RegularCardFactory <E>{
    E getInstance(Color color, int number);
}
