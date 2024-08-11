package org.example;

public class QueueController {
    private PlayerQueue players = new PlayerQueue();

    private boolean isCounterClock = true; // Moves to the right of the array, else moves to the left.

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

}
