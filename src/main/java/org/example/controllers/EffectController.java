package org.example.controllers;

import org.example.card.Card;
import org.example.core.enums.CardType;
import org.example.core.enums.Color;
import org.example.match.Player;

import java.util.Random;

import static java.util.Objects.isNull;
import static org.example.core.enums.Color.*;

public class EffectController {

    private static final Color[] AVAILABLE_COLORS = {RED, GREEN, BLUE, YELLOW};

    private final Random rand = new Random();
    private final QueueController queueController = QueueController.getInstance();
    private final MatchController matchController = MatchController.getInstance();
    private final UiController uiController = new UiController();
    private static EffectController effectController;

    private EffectController(){}

    public static EffectController getInstance(){
        if(isNull(effectController))
            effectController = new EffectController();
        return effectController;
    }

    public void applyEffect(Card card){
        if (isNull(card)) {
            uiController.displayMessage("No valid card to play.");
            return;
        }
        CardType type = card.getType();
        handleEffect(type);
    }

    protected void draw(Player player, int amount){
        for(int i = 0 ; i < amount; i++)
            player.addCard(matchController.drawCard());
    }

    private void handleEffect(CardType type) {
        switch (type) {
            case Reverse -> reverse();
            case Skip -> skip();
            case ChangeColor -> selectRandomColor();
            case DrawFour -> {
                selectRandomColor();
                drawFour();
            }
            case DrawTwo -> drawTwo();
        }
    }

    private void selectRandomColor() {
        Color color = pickRandomColor();
        changeColor(color);
        uiController.displayMessage(color + " Color was picked.");
    }

    private Color pickRandomColor() {
        return AVAILABLE_COLORS[rand.nextInt(AVAILABLE_COLORS.length)];
    }

    private void reverse(){
        queueController.reverse();
    }

    private void skip(){
        queueController.skip();
    }

    private void changeColor(Color color){
        matchController.changeColor(color);
    }

    private void drawFour(){
        Player player = queueController.nextPlayer();
        draw(player, 4);
    }

    public void drawTwo(){
        Player player = queueController.nextPlayer();
        draw(player, 2);
    }

}
