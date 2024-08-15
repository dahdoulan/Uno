package org.example;

public class SkipCard extends Card{
    public SkipCard(Color color) {
        super(color, CardType.Skip);
    }

    @Override
    public void accept(CardVisitor visitor) {
        visitor.visit(this);
    }
}
