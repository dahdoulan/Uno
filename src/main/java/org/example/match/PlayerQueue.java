package org.example.match;

import java.util.Arrays;
import java.util.Iterator;

public class PlayerQueue implements Iterable<Player>{
    private final int MAX_SIZE = 8;
    private int size = 0;
    private final Player[] players = new Player[MAX_SIZE];
    private int currentPlayer = 0;

    public void add(Object o) {
        if(o == null){
            throw(new NullPointerException("Player is null."));
        }
        if(size >= MAX_SIZE){
            throw(new IllegalStateException("Can NOT add player, player queue is full."));
        }

        Player player = (Player) o;

        players[size++] = player;

    }

    public void remove(Object o) throws Exception {
        if(o == null){
            throw(new NullPointerException("Player is null."));
        }
        if(size <= 0){
            throw(new Exception("Can NOT remove player, player queue is empty."));
        }

        Player player = (Player) o;
        players[size] = player;

        int removedIndex = -1;

        for(int i = 0; i<size; i++){
            Player temp = players[i];

            if(player.equals(temp)){
                players[i] = null;
                removedIndex = i;
                break;
            }
        }

        if(removedIndex != -1){
            for (int i = removedIndex + 1; i<size; i++){
                players[i - 1] = players[i];
            }
            size--;
        }
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

    public Player get(int i){
        Player player = players[i];
        if(i < 2 || i > size){
            throw (new IndexOutOfBoundsException());
        }
        if(player == null){
            throw (new NullPointerException("Player of index " + i + " is null."));
        }

        return player;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayer;
    }

    public Player getCurrentPlayer(){
        Player player = players[currentPlayer];
        if(player == null){
            throw(new NullPointerException("Can NOT return current player because it is null."));
        }

        return player;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public Iterator<Player> iterator() {
        return Arrays.stream(players).iterator();
    }

}