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
        System.out.print("Enter your number choice: ");
    }

    private void getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter player name: ");
                String name = scanner.nextLine();
                player = new Player(name);
                System.out.println("[" + name + "]" + " Player Created");
                break;
            case 2:
                if (player == null) {
                    System.out.println("Please create player first!");
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
        while (player.getScore() < 3 && computerPlayer.getComputerScore() < 3) {
            System.out.print("Enter your move (rock, paper, scissors): ");
            String playerMove = scanner.nextLine();
            String computerMove = computerPlayer.generateMove();
            System.out.println("Computer chose: " + computerMove);
            decideWinner(playerMove, computerMove);

            if (player.getScore() >= 3) {
                System.out.println("Player has won the game 3 times!");
                gameRunning = false;
                break; 
            } else if (computerPlayer.getComputerScore() >= 3) {
                System.out.println("Computer has won the game 3 times!");
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

