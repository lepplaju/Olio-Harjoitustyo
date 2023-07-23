package com.example.lutemon.classes;

import java.io.Serializable;

public class GameFile implements Serializable {

    private static GameFile gameFile;
    private String fileName;
    private int highestLevelAvailable;
    private Inventory inventory;
    private Home home;

    public static GameFile getInstance(){
        if (gameFile == null) {
            gameFile = new GameFile();
        }
        return gameFile;
    }
    private GameFile(){
        this.inventory = Inventory.getInstance();
        this.home = Home.getInstance();
        this.highestLevelAvailable = 1;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public Home getHome(){
        return home;
    }

    public int getHighestLevelAvailable() {
        return highestLevelAvailable;
    }

    public void setHighestLevelAvailable(int highestLevelAvailable) {
        this.highestLevelAvailable = highestLevelAvailable;
    }
}
