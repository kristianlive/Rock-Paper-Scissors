package org.example;

public class Main {
    public static void main(String[] args) {

        ComputerPlayer computerPlayer = new ComputerPlayer();
        String computerMove = computerPlayer.generateMove();
        System.out.println("Computer chose: " + computerMove);


    }
}