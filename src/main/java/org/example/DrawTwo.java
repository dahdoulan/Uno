package org.example;

public class DrawTwo extends Card{
    public DrawTwo(Color color) {
        super(color, CardType.DrawTwo);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }
}
