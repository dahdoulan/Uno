package org.example;

public class ReverseCard implements SpecialCard{
    private Color color;

    public ReverseCard(Color color) {
        this.color = color;
    }

    @Override
    public void execute(Player player) {

    }

    @Override
    public void printInfo() {
        System.out.printf("Card Type: Reverse Card | Card Color: %s \n", this.color.toString());
    }
}
