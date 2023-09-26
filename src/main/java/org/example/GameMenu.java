package org.example;

import java.util.Random;
import java.util.Scanner;

public class GameMenu {
    private String playerName;
    private int playerScore;
    private int computerScore;
    private int roundsToWin;

    public GameMenu() {
        this.playerName = "";
        this.playerScore = 0;
        this.computerScore = 0;
        this.roundsToWin = 0;
    }


    public void setPlayerName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your name: ");
        this.playerName = scanner.nextLine();
        System.out.println("Welcome, " + playerName + "!");

    }

    private void startNewGame() {
        if (playerName.equals("")) {
            System.out.println("Du måste ange ditt namn först.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Först till hur många vinster?");
        this.roundsToWin = scanner.nextInt();

        this.playerScore = 0;
        this.computerScore = 0;

        while (playerScore < roundsToWin && computerScore < roundsToWin) {
            playRound();
        }

        displayFinalScore();
    }

    private void playRound() {
        String playerMove = playerChoice();
        String computerMove = computerChoice();

        System.out.println("Du valde: " + playerMove);
        System.out.println("Datorn valde: " + computerMove);

        if (playerMove.equals(computerMove)) {
            System.out.println("Det blev oavgjort!");
        } else if ((playerMove.equals("sten") && computerMove.equals("sax")) ||
                (playerMove.equals("sax") && computerMove.equals("påse")) ||
                (playerMove.equals("påse") && computerMove.equals("sten"))) {
            System.out.println("Du vinner denna omgång!");
            playerScore++;
        } else {
            System.out.println("Datorn vinner denna omgång!");
            computerScore++;
        }
    }

    private String playerChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj: sten, sax, eller påse");
        String choice = scanner.nextLine().toLowerCase();
        while (!choice.equals("sten") && !choice.equals("sax") && !choice.equals("påse")) {
            System.out.println("Ogiltigt val. Välj: sten, sax, eller påse");
            choice = scanner.nextLine().toLowerCase();
        }
        return choice;
    }

    private String computerChoice() {
        String[] choices = {"sten", "sax", "påse"};
        int randomIndex = new Random().nextInt(choices.length);
        return choices[randomIndex];
    }

    private void displayFinalScore() {
        System.out.println("Slutresultat: " + playerName + " " + playerScore + " - Dator " + computerScore);
        if (playerScore > computerScore) {
            System.out.println(playerName + " vinner!");
        } else {
            System.out.println("Datorn vinner!");
        }
    }






    public void startMenu(){
        System.out.println("Welcome to Rock Paper Scissors GAME !");
        System.out.println("1. Ange ditt namn");
        System.out.println("2. Starta nytt spel");
        System.out.println("3. Avsluta");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                setPlayerName();
                break;
            case 2:
                startNewGame();
                break;
            case 3:
                System.out.println("Tack för att du spelade! Hejdå!");
                System.exit(0);
                break;
            default:
                System.out.println("Ogiltigt val. Försök igen.");
                break;
        }

    }
}
