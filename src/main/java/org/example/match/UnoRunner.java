package org.example.match;


import org.example.card.Card;
import org.example.controllers.EffectController;
import org.example.controllers.MatchController;
import org.example.controllers.QueueController;
import org.example.controllers.UiController;
import org.example.core.game.Game;

public class UnoRunner implements Game {

    private final QueueController queueController = QueueController.getInstance();
    private final MatchController matchController = MatchController.getInstance();
    private final EffectController effectController = EffectController.getInstance();
    private final GameInitializer gameInitializer = new GameInitializer();
    private final UiController uiController = new UiController();

    @Override
    public void play() {
        gameInitializer.initializeGame();
        runGameLoop();
    }

    private void runGameLoop() {
        while (true) {
            Player currentPlayer = queueController.getCurrentPlayer();
            if (isEndGame(currentPlayer))
                break;
            uiController.displayMessage("---> " + currentPlayer + " please choose a card to play. <---");
            uiController.displayMessage("---> Current card color " + matchController.getCurrentColor() + " <---");
            playTurn(currentPlayer);
            queueController.nextPlayer();
            uiController.displayMessage("------------------------------------------");
        }
    }

    private boolean isEndGame(Player currentPlayer) {
        if (currentPlayer.getHand().isEmpty()) {
            uiController.displayMessage("---> " + currentPlayer + " HAS WON THE MATCH !!!! <---");
            return true;
        }
        return false;
    }

    private void playTurn(Player currentPlayer) {
        uiController.displayPlayerHand(currentPlayer);
        handlePlayedCard(currentPlayer, matchController.chooseCard(currentPlayer.getHand()));
    }

    private void handlePlayedCard(Player currentPlayer, Card card) {
        if (card.isEmptyCard())
            currentPlayer.getHand().add(matchController.drawCard());
        else
            effectController.applyEffect(card);
    }
}
