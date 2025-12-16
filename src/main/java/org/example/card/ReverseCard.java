package org.example.card;

import org.example.core.card.visitor.CardVisitor;
import org.example.core.enums.CardType;
import org.example.core.enums.Color;

public class ReverseCard extends Card{
    public ReverseCard(Color color) {
        super(color, CardType.Reverse);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }
}
