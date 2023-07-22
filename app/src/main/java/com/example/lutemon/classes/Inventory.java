package com.example.lutemon.classes;

import java.io.Serializable;

public class Inventory extends Storage implements Serializable {
    private static Inventory inventory;

    private Inventory() {
        super();
    }

    public static Inventory getInstance() {
        if (inventory == null) {
            inventory = new Inventory();
        }
        return inventory;
    }

    public void moveLutemonToHome(Lutemon lutemon) {
        SaveFileManager saveFileManager = SaveFileManager.getInstance();
        GameFile gameFile = saveFileManager.getGameFile();
        Home home = gameFile.getHome();
        lutemon.setStorageLocation("Home");
        home.addLutemon(lutemon);
        lutemons.remove(lutemon);
    }
}
