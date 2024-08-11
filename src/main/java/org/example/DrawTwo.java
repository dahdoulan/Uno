package org.example;

public class DrawTwo implements SpecialCard{
    private Color color;

    public DrawTwo(Color color) {
        this.color = color;
    }

    @Override
    public void execute(Player player) {

    }

    @Override
    public void printInfo() {
        System.out.printf("Card Type: Draw | Two Card Color: %s \n", this.color.toString());
    }
}
