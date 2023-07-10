package com.example.lutemon.classes;

import java.io.Serializable;

public class GameFile implements Serializable {

    private static GameFile gameFile;
    private String fileName;
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
    }

    public Inventory getInventory() {
        return inventory;
    }


    public Home getHome(){
        return home;
    }

}
