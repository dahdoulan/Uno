package org.example.cards;

import org.example.enums.Color;

public class CardEligibilityVisitor implements CardVisitor {
    private final Card topCard;
    private final Color currentColor;
    private boolean isEligible;

    public CardEligibilityVisitor(Card topCard, Color currentColor) {
        this.topCard = topCard;
        this.currentColor = currentColor;
    }

    public boolean isEligible() {
        return isEligible;
    }

    @Override
    public void visit(RegularCard regularCard) {
        if (topCard instanceof RegularCard) {
            RegularCard card = (RegularCard) topCard;

            isEligible = (regularCard.getColor() == currentColor) || (regularCard.getNumber() == card.getNumber());
        } else {
            isEligible = (regularCard.getColor() == currentColor);
        }
    }

    @Override
    public void visit(SkipCard skipCard) {
        isEligible = (skipCard.getColor() == currentColor) || (topCard instanceof SkipCard);
    }

    @Override
    public void visit(ReverseCard reverseCard) {
        isEligible = (reverseCard.getColor() == currentColor) || (topCard instanceof ReverseCard);
    }

    @Override
    public void visit(DrawTwo drawTwo) {
        isEligible = (drawTwo.getColor() == currentColor) || (topCard instanceof DrawTwo);
    }

    @Override
    public void visit(DrawFour drawFour) {
        isEligible = true;
    }

    @Override
    public void visit(ChangeColor changeColor) {
        isEligible = true;
    }
}
