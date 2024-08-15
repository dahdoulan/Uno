package org.example.cards;

import org.example.enums.CardType;
import org.example.enums.Color;

public class SkipCard extends Card{
    public SkipCard(Color color) {
        super(color, CardType.Skip);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }
}
