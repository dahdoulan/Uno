package org.example.controllers;

import org.example.match.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UiController {
        private final Scanner scanner = new Scanner(System.in);

        public int getNumberOfPlayers() {
        while (true) {
            try {
                int numOfPlayers = scanner.nextInt();
                scanner.nextLine();
                return numOfPlayers;
            } catch (InputMismatchException e) {
                displayMessage("Input provided is NOT an Integer. Please try again.");
                scanner.nextLine();
            }
        }
    }

        public String getPlayerName() {
        while (true) {
            try {
                return scanner.nextLine();
            } catch (InputMismatchException e) {
                displayMessage("Input provided is NOT a valid String. Please try again.");
            }
        }
    }

        public void displayPlayerHand(Player player) {
            player.printHand();
        }

        public void displayMessage(String message) {
            System.out.println(message);
        }
    }

