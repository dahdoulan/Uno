package org.example.card;

import org.example.core.card.visitor.CardVisitor;
import org.example.core.enums.CardType;
import org.example.core.enums.Color;

public class RegularCard extends Card{
    private final int number;

    public RegularCard(int number, Color color) {
        super(color, CardType.Regular);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void printInfo() {
        System.out.printf("Card Number: %d | Card Color: %s \n", this.number, getColor());
    }
}
