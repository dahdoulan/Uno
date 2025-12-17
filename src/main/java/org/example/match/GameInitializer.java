package org.example.match;

import org.example.controllers.MatchController;
import org.example.controllers.QueueController;
import org.example.controllers.UiController;

import static java.util.Objects.nonNull;

public class GameInitializer {

    private static final int PLAYER_HAND_SIZE = 7;

    private final QueueController queueController = QueueController.getInstance();
    private final MatchController matchController = MatchController.getInstance();
    private final UiController uiController = new UiController();

    public void initializeGame(){
        int numOfPlayers = validateNumOfPlayers();
        initPlayers(numOfPlayers);
        initPlayerHands();
    }

    protected boolean isValidNumOfPlayers(int numOfPlayers) {
        return numOfPlayers >= 2 && numOfPlayers <= 8;
    }

    private int validateNumOfPlayers(){
        int numOfPlayers;
        while(true){
            uiController.displayMessage("Please enter the number of players.");
            numOfPlayers = uiController.promptNumberOfPlayers();
            if(isValidNumOfPlayers(numOfPlayers)){
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
            String name = uiController.inputPlayerName();
            Player player = new Player(name);
            queueController.addPlayer(player);
        }
    }

    private void initPlayerHands(){
        PlayerQueue players = queueController.getPlayers();
        for(Player player : players)
            if(nonNull(player))
                initiatePlayerHand(player);
    }

    private void initiatePlayerHand(Player player) {
        for(int i = 0; i< PLAYER_HAND_SIZE; i++)
            player.addCard(matchController.drawCard());

        uiController.displayMessage(player.toString());
        uiController.displayPlayerHand(player);
    }
}
