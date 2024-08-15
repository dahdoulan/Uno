package org.example.cards;

import org.example.enums.CardType;
import org.example.enums.Color;

public class ChangeColor extends Card{
    public ChangeColor() {
        super(Color.WILDCARD, CardType.ChangeColor);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void printInfo() {
        System.out.println("Card Type: Change Color");
    }
}
