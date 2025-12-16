package org.example.card;

import org.example.core.card.visitor.CardVisitor;
import org.example.core.enums.CardType;
import org.example.core.enums.Color;

public abstract class Card {
    private final Color color;
    private final CardType type;

    public Card(Color color, CardType type) {
        this.color = color;
        this.type = type;
    }

    public void printInfo() {
        System.out.printf("Card Type: " + getType() +"| Card Color: %s \n", getColor());
    }

    public boolean isEmptyCard() {
        return this instanceof EmptyCard;
    }

    public Color getColor() {
        return color;
    }

    public CardType getType() {
        return type;
    }

    public abstract void accept(CardVisitor visitor);
}
