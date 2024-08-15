package org.example;

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

    public Color getColor() {
        return color;
    }

    public CardType getType() {
        return type;
    }

    public abstract void accept(CardVisitor visitor);
}
