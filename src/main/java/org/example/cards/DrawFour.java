package org.example.cards;

import org.example.enums.CardType;
import org.example.enums.Color;

public class DrawFour extends Card{
    public DrawFour() {
        super(Color.WILDCARD, CardType.DrawFour);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void printInfo() {
        System.out.println("Card Type: Draw Four");
    }
}
