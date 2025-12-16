package org.example.card;

import org.example.core.card.visitor.CardVisitor;
import org.example.core.enums.CardType;
import org.example.core.enums.Color;

public class SkipCard extends Card{
    public SkipCard(Color color) {
        super(color, CardType.Skip);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }
}
