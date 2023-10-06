package org.example;

public class GameSettings {

    //singleton design pattern
    private static GameSettings instance = null; // private static därför ingen access
    private int roundsToWin;

    private GameSettings(){
        roundsToWin = 3;
    }

    public static GameSettings getInstance() { // Enda sättet att få tillgång till GameSettings, bara 1 exemplar
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    public int getRoundsToWin() {
        return roundsToWin;
    }

    public void setRoundsToWin(int roundsToWin) { // kna användas för att sätta ny global värde
        this.roundsToWin = roundsToWin;
    }
}

