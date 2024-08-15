package org.example.controllers;

import org.example.enums.Color;
import org.example.match.Player;
import org.example.cards.Card;
import org.example.enums.CardType;

public class EffectController {
    private final QueueController queueController = QueueController.getInstance();
    private final MatchController matchController = MatchController.getInstance();
    private final UiController uiController = new UiController();
    private static EffectController effectController;

    private EffectController(){

    }

    public void reverse(){
        queueController.reverse();
    }

    public void skip(){
        queueController.skip();
    }

    public void changeColor(Color color){
        matchController.changeColor(color);
    }

    private void draw(Player player, int amount){
        for(int i = 0 ; i<amount; i++){
            player.addCard(matchController.drawCard());
        }
    }

    public void drawFour(Color color){
        Player player = queueController.move();
        draw(player, 4);
        matchController.changeColor(color);
    }

    public void drawTwo(){
        Player player = queueController.move();
        draw(player, 2);
    }

    public void applyEffect(Card card){
        if (card == null) {
            uiController.displayMessage("No valid card to play.");
            return;
        }
        CardType type = card.getType();

        if(type == CardType.Reverse){
            reverse();
        } else if (type == CardType.Skip) {
            skip();
        } else if (type == CardType.DrawFour) {
            uiController.displayMessage("Please enter the card color.");
            drawFour(matchController.chooseColor());
        } else if (type == CardType.ChangeColor) {
            uiController.displayMessage("Please enter the card color.");
            changeColor(matchController.chooseColor());
        } else if (type == CardType.DrawTwo) {
            drawTwo();
        }
    }

    public static EffectController getInstance(){
        if(effectController == null){
            effectController = new EffectController();
        }

        return effectController;
    }
}
