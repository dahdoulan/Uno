package org.example;

public interface CardVisitor {
    void visit(RegularCard regularCard);
    void visit(SkipCard skipCard);
    void visit(ReverseCard reverseCard);
    void visit(DrawTwo drawTwo);
    void visit(DrawFour drawFour);
    void visit(ChangeColor changeColor);
}
