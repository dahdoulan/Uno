package org.example;

public class ChangeColor extends Card{
    public ChangeColor(Color color) {
        super(color, CardType.ChangeColor);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void printInfo() {
        System.out.println("Card Type: Change Color");
    }
}
