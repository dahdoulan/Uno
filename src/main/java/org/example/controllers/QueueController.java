package org.example.controllers;

import org.example.match.Player;
import org.example.match.PlayerQueue;

import static java.util.Objects.isNull;

public class QueueController {
    private final PlayerQueue players = new PlayerQueue();
    private static QueueController queueController;
    private boolean isCounterClock = true; // Moves to the right of the array, else moves to the left.

    private QueueController(){

    }

    public static QueueController getInstance(){
        if(isNull(queueController))
            queueController = new QueueController();
        return queueController;
    }

    public Player nextPlayer(){
        if(isCounterClock)
            return players.next();
        return players.previous();
    }

    public void addPlayer(Player player){
        if(isNull(player))
            throw(new NullPointerException("Can NOT add player to queue, player is null."));
        players.addPlayerToQueue(player);
    }

    public PlayerQueue getPlayers(){
        return players;
    }

    public void reverse(){
        isCounterClock = !isCounterClock;
    }

    public void skip(){
        nextPlayer();
    }

    public Player getCurrentPlayer(){
        return players.getCurrentPlayer();
    }
}
