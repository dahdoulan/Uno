package org.example.core.card;

import org.example.core.enums.Color;

public interface RegularCardFactory <E>{
    E getInstance(Color color, int number);
}
