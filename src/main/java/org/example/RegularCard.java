package org.example;

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
