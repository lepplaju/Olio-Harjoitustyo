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
        lutemon.setStorageLocation("Storage");
        home.addLutemon(lutemon);
        lutemons.remove(lutemon);
    }
    public void moveLutemonToGraveyard(Lutemon lutemon){
        SaveFileManager saveFileManager = SaveFileManager.getInstance();
        GameFile gameFile = saveFileManager.getGameFile();
        Graveyard graveyard = gameFile.getGraveyard();
        graveyard.addLutemon(lutemon);
        lutemon.setStorageLocation("Graveyard");
        lutemons.remove(lutemon);
    }
}
