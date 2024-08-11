package org.example;

public class SkipCard implements SpecialCard{
    private Color color;

    public SkipCard(Color color) {
        this.color = color;
    }

    @Override
    public void execute(Player player) {

    }

    @Override
    public void printInfo() {
        System.out.printf("Card Type: Skip Card | Card Color: %s \n", this.color.toString());
    }
}
