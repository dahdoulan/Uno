package org.example.cards;

import org.example.enums.Color;

public class UnoRegularCardFactory implements RegularCardFactory <Card>{
    @Override
    public  Card getInstance(Color color, int number) {
        if(number < 0 || number > 9){
            throw new IllegalArgumentException("Number should be between 0 - 9.");
        }

        return new RegularCard(number, color);
    }
}
