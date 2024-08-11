package org.example;

import java.util.Queue;
import java.util.Scanner;

public class Uno extends Game{
    private QueueController queueController = new QueueController();
    private MatchController matchController = new MatchController();

    public void initializeGame(){
        try(Scanner scan = new Scanner(System.in)){
            PlayerQueue players = queueController.getPlayers();

            matchController.initializeDeck();
            int numOfPlayers;

            while(true){
                System.out.println("Please enter the number of players.");
                numOfPlayers = scan.nextInt();
                scan.nextLine();
                System.out.println("----------------------------------------------");

                if(numOfPlayers < 2 || numOfPlayers > 8){
                    System.out.println("Least number of players is 2, And the maximum is 8.");
                    System.out.println("Please try again.");
                    System.out.println("----------------------------------------------");
                    continue;
                }
                break;
            }

            for(int i = 0; i<numOfPlayers; i++){
                System.out.println("Please enter the name of Player - " + (i + 1));

                String name = scan.nextLine();

                Player player = new Player(name);

                queueController.addPlayer(player);
            }

            for(Player player : players){
                for(int i = 0; i<7; i++){
                    player.addCard(matchController.drawCard());
                }
                System.out.println(player.toString());
                player.getHand();
                System.out.println("----------------------------------------------");
            }

            matchController.initializePile();

        }catch(Exception e){

        }
    }

    public void playTurn(Card card){

    }

    @Override
    public void play() {
        initializeGame();

        try(Scanner scan = new Scanner(System.in)) {
            while (true){
                Player currentPlayer = queueController.getCurrentPlayer();
                System.out.println("Please choose a card to play.");

                System.out.println(currentPlayer.toString());
                currentPlayer.getHand();

                int cardIndex = scan.nextInt();
                scan.nextLine();
               // playTurn();
                queueController.move();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
