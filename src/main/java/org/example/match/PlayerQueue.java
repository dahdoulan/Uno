package org.example.match;

import java.util.Arrays;
import java.util.Iterator;

import static java.util.Objects.isNull;

public class PlayerQueue implements Iterable<Player>{
    private final int MAX_SIZE = 8;
    private int size = 0;
    private int currentPlayer = 0;
    private final Player[] players = new Player[MAX_SIZE];

    @Override
    public Iterator<Player> iterator() {
        return Arrays.stream(players).iterator();
    }

    public void addPlayerToQueue(Object o) {
        if(isNull(o))
            throw(new NullPointerException("Player is null."));
        if(size >= MAX_SIZE)
            throw(new IllegalStateException("Can NOT add player, player queue is full."));
        Player player = (Player) o;
        players[size++] = player;
    }

    public int size(){
        return this.size;
    }

    public Player next(){
        currentPlayer = (currentPlayer + 1) % size;
        return players[currentPlayer];
    }

    public Player previous(){
        currentPlayer = (currentPlayer - 1 + size) % size;
        return players[currentPlayer];
    }


    public Player getCurrentPlayer(){
        Player player = players[currentPlayer];
        if(isNull(player))
            throw(new NullPointerException("Can NOT return current player because it is null."));
        return player;
    }
}