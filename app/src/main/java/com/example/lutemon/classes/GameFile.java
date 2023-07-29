package com.example.lutemon.classes;

import java.io.Serializable;

public class GameFile implements Serializable {

    private static GameFile gameFile;
    private String fileName;
    private int highestLevelAvailable;
    private Inventory inventory;
    private Home home;
    private Graveyard graveyard;

    public static GameFile getInstance() {
        if (gameFile == null) {
            gameFile = new GameFile();
        }
        return gameFile;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }

    private GameFile() {
        this.inventory = Inventory.getInstance();
        this.home = Home.getInstance();
        this.graveyard = Graveyard.getInstance();
        this.highestLevelAvailable = 1;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public Home getHome() {
        return home;
    }

    public int getHighestLevelAvailable() {
        return highestLevelAvailable;
    }

    public void levelCompleted() {
        this.highestLevelAvailable += 1;
    }

    public void setHighestLevelAvailable(int highestLevelAvailable) {
        this.highestLevelAvailable = highestLevelAvailable;
    }
}
