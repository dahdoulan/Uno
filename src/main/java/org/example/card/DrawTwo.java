package org.example.card;

import org.example.core.card.visitor.CardVisitor;
import org.example.core.enums.CardType;
import org.example.core.enums.Color;

public class DrawTwo extends Card{
    public DrawTwo(Color color) {
        super(color, CardType.DrawTwo);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }
}
