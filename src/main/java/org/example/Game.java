package org.example;

import java.util.Scanner;

public class
Game {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private ComputerPlayer computerPlayer = new ComputerPlayer();
    private boolean gameRunning = true;

    public void startGame() {
        while (gameRunning) {
            displayMenu();
            getUserChoice();
        }
    }

    private void displayMenu() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Enter your choice:");
        System.out.println("1. Create new player");
        System.out.println("2. Start a new game");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private void getUserChoice() {

        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Hanterar strängar som input
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter player name: ");
                String name = scanner.nextLine();
                player = new Player(name);
                System.out.println("[" + name + "]" + " Player created.");
                break;
            case 2:
                if (player == null) {
                    System.out.println("IMPORTANT!!!"+"\nPlease create a player first!");
                } else {
                    playRound();
                }
                break;
            case 3:
                exitGame();
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }
    }

    private void playRound() {
        GameSettings settings = GameSettings.getInstance();

        System.out.println("Enter the number of rounds needed to win. Default is " + settings.getRoundsToWin());
        String input = scanner.nextLine();

        int roundsToWin;
        if (input.isEmpty()) {
            roundsToWin = settings.getRoundsToWin();
        } else {
            roundsToWin = Integer.parseInt(input);
        }

        settings.setRoundsToWin(roundsToWin); // kan återanvändas vid behov utanför metoden

        while (player.getScore() < roundsToWin && computerPlayer.getComputerScore() < roundsToWin) {
            String playerMove;
            do {
                System.out.println("-------------------------------------------------------------");
                System.out.print("[" + player.getName() + "]" + "\nEnter your move (rock, paper, scissors): ");
                playerMove = scanner.nextLine();
                if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {
                    System.out.println("Invalid move. Please enter 'rock', 'paper', or 'scissors'.");
                }
            } while (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors"));

            String computerMove = computerPlayer.generateMove();
            System.out.println("Computer chose: " + computerMove);
            decideWinner(playerMove, computerMove);

            if (player.getScore() >= roundsToWin) {
                System.out.println("Player has won the game " + roundsToWin + " times!");
                gameRunning = false;
                break;
            } else if (computerPlayer.getComputerScore() >= roundsToWin) {
                System.out.println("Computer has won the game " + roundsToWin + " times!");
                System.out.println("Final Score: " + player.getScore() + "-" + computerPlayer.getComputerScore());
                gameRunning = false;
            }

        }
    }


    private void decideWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            System.out.println("It's a tie!");
        } else if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
                (playerMove.equals("scissors") && computerMove.equals("paper")) ||
                (playerMove.equals("paper") && computerMove.equals("rock"))) {
            System.out.println("Player wins!");
            player.incrementScore();
        } else {
            System.out.println("Computer wins!");
            computerPlayer.incrementScore();
        }
        System.out.println("Player Score: " + player.getScore());
        System.out.println("Computer Score: " + computerPlayer.getComputerScore());

    }

    private void exitGame() {
        gameRunning = false;
        System.out.println("Thank you for playing!");
    }
}

