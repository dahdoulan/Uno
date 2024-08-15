package org.example.cards;

import org.example.enums.CardType;
import org.example.enums.Color;

public class ReverseCard extends Card{
    public ReverseCard(Color color) {
        super(color, CardType.Reverse);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }
}
