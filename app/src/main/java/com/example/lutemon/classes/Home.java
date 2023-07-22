package com.example.lutemon.classes;

import java.io.Serializable;

public class Home extends Storage implements Serializable {
    private static Home storage;
    private Home(){
        super();
    }
    public static Home getInstance(){
        if (storage == null) {
            storage = new Home();
        }
        return storage;
    }

    public void createLutemon(Lutemon lutemon){
        lutemon.setStorageLocation("Home");
        lutemons.add(lutemon);
    }

    public void moveLutemonToInventory(Lutemon lutemon){
        SaveFileManager saveFileManager = SaveFileManager.getInstance();
        GameFile gameFile = saveFileManager.getGameFile();
        Inventory inventory = gameFile.getInventory();
        lutemon.setStorageLocation("Inventory");
        inventory.addLutemon(lutemon);
        lutemons.remove(lutemon);

    }


}
