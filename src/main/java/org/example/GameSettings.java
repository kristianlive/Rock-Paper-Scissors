package org.example;

public class GameSettings {

    private static GameSettings instance = null;

    private GameSettings(){

    }

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }
}
