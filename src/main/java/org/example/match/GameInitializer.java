package org.example.match;

import org.example.controllers.MatchController;
import org.example.controllers.QueueController;
import org.example.controllers.UiController;

public class GameInitializer {
    private final QueueController queueController = QueueController.getInstance();
    private final MatchController matchController = MatchController.getInstance();
    private final UiController uiController = new UiController();

    private int initNumberOfPlayers(){
        int numOfPlayers;

        while(true){
            uiController.displayMessage("Please enter the number of players.");
            numOfPlayers = uiController.getNumberOfPlayers();

            if(numOfPlayers < 2 || numOfPlayers > 8){
                uiController.displayMessage("Least number of players is 2, And the maximum is 8.");
                uiController.displayMessage("Please try again.");
                continue;
            }
            break;
        }

        return numOfPlayers;
    }
    private void initPlayers(int numOfPlayers){
        for(int i = 0; i<numOfPlayers; i++){
            uiController.displayMessage("Please enter the name of Player - " + (i + 1));

            String name = uiController.getPlayerName();
            Player player = new Player(name);

            queueController.addPlayer(player);
        }
    }
    private void initPlayerHands(){
        PlayerQueue players = queueController.getPlayers();
        for(Player player : players){
            if(player != null){
                for(int i = 0; i<7; i++){
                    player.addCard(matchController.drawCard());
                }
                uiController.displayMessage(player.toString());
                uiController.displayPlayerHand(player);
            }
        }
    }
    public void initializeGame(){
        int numOfPlayers = initNumberOfPlayers();
        initPlayers(numOfPlayers);
        initPlayerHands();
    }
}
