package org.example.card;

import org.example.core.enums.CardType;
import org.example.core.enums.Color;
import org.example.core.card.visitor.CardVisitor;

import static org.example.core.enums.CardType.NoType;
import static org.example.core.enums.Color.EMPTY;

public class EmptyCard extends Card{
    public EmptyCard() {
        super(EMPTY, NoType);
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public CardType getType() {
        return super.getType();
    }

    @Override
    public void accept(CardVisitor visitor) {

    }
}
