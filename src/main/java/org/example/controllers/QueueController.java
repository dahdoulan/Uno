package org.example.controllers;

import org.example.match.Player;
import org.example.match.PlayerQueue;

public class QueueController {
    private final PlayerQueue players = new PlayerQueue();
    private static QueueController queueController;
    private boolean isCounterClock = true; // Moves to the right of the array, else moves to the left.

    private QueueController(){

    }

    public Player move(){
        if(isCounterClock){
            return players.next();
        }

        return players.previous();
    }

    public void addPlayer(Player player){
        if(player == null){
            throw(new NullPointerException("Can NOT add player to queue, player is null."));
        }

        players.add(player);
    }

    public PlayerQueue getPlayers(){
        return players;
    }

    public void reverse(){
        isCounterClock = !isCounterClock;
    }

    public void skip(){
        move();
    }

    public Player getCurrentPlayer(){
        return players.getCurrentPlayer();
    }

    public static QueueController getInstance(){
        if(queueController == null){
            queueController = new QueueController();
        }
        return queueController;
    }

}
