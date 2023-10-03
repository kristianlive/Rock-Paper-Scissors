package org.example;

public class GameSettings {
    private static GameSettings instance = null;
    private int roundsToWin;

    private GameSettings(){
        roundsToWin = 3;
    }

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    public int getRoundsToWin() {
        return roundsToWin;
    }

    public void setRoundsToWin(int roundsToWin) {
        this.roundsToWin = roundsToWin;
    }
}

