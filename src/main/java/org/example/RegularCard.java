package org.example;

public class RegularCard implements Card {
    private int number;
    private Color color;

    public RegularCard(int number, Color color) {
        this.number = number;
        this.color = color;
    }

    @Override
    public void printInfo() {
        System.out.printf("Card Number: %d | Card Color: %s \n", this.number, this.color.toString());
    }
}
