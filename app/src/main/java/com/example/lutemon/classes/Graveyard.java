package com.example.lutemon.classes;

import java.io.Serializable;

public class Graveyard extends Storage implements Serializable {

    private static Graveyard storage;

    private Graveyard() {
        super();
    }

    public static Graveyard getInstance() {
        if (storage == null) {
            storage = new Graveyard();
        }
        return storage;
    }

    public void deleteLutemonPermanently(Lutemon lutemon) {
        SaveFileManager saveFileManager = SaveFileManager.getInstance();
        GameFile gameFile = saveFileManager.getGameFile();
        Graveyard graveyard = gameFile.getGraveyard();
        graveyard.lutemons.remove(lutemon);
    }
}
