package org.example;
import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    private String computerResult = "";
    private int computerScore = 0;



    public String generateMove() {

        int randomNum = ThreadLocalRandom.current().nextInt(1, 4);

        if (randomNum == 1) {
            computerResult = ROCK;
        } else if (randomNum == 2) {
            computerResult = PAPER;
        } else if (randomNum == 3) {
            computerResult = SCISSORS;

        }
        return computerResult;
    }

    public int getComputerScore() {
        return computerScore;
    }
    public void incrementScore() {
        this.computerScore += 1;
    }
}
