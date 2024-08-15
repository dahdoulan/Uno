package org.example.cards;

import org.example.enums.CardType;
import org.example.enums.Color;

public class UnoSpecialCardFactory implements SpecialCardFactory<Card> {
    @Override
    public Card getInstance(CardType type, Color color) {
        if(type == CardType.DrawFour){
            return new DrawFour();
        } else if (type == CardType.ChangeColor) {
            return new ChangeColor();
        } else if (type == CardType.DrawTwo) {
            return new DrawTwo(color);
        } else if (type == CardType.Reverse) {
            return new ReverseCard(color);
        }

        return new SkipCard(color);
    }
}
