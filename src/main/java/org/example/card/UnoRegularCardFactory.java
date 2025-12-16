package org.example.card;

import org.example.core.card.RegularCardFactory;
import org.example.core.enums.Color;

public class UnoRegularCardFactory implements RegularCardFactory<Card> {
    @Override
    public  Card getInstance(Color color, int number) {
        if(isValidCardNumber(number))
            throw new IllegalArgumentException("Number should be between 0 - 9.");
        return new RegularCard(number, color);
    }

    private boolean isValidCardNumber(int number) {
        return number < 0 || number > 9;
    }
}
