package org.example;

public class DrawFour extends Card{
    public DrawFour(Color color) {
        super(color, CardType.DrawFour);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void printInfo() {
        System.out.println("Card Type: Draw Four");
    }
}
