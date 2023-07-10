package com.example.lutemon.classes;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveFileManager {
    private GameFile gameFile;
    private static SaveFileManager instance;

    public static SaveFileManager getInstance() {
        if (instance == null) {
            instance = new SaveFileManager();
        }
        return instance;
    }

    public void saveFile(Context context) {

        instance = SaveFileManager.getInstance();
        gameFile = instance.getGameFile();
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(context.openFileOutput("saveFile.data", Context.MODE_PRIVATE));
            fileWriter.writeObject(gameFile);
            fileWriter.close();
            System.out.println("Tallentaminen onnistui!");
        } catch (IOException e) {
            System.out.println("Tiedoston tallentamisessa tapahtui virhe!");
        }

    }

    public void loadFile(Context context) {
        try {
            instance = SaveFileManager.getInstance();
            gameFile = instance.getGameFile();
            ObjectInputStream fileReader = new ObjectInputStream(context.openFileInput("saveFile.data"));
            gameFile = (GameFile)fileReader.readObject();
            fileReader.close();
            System.out.println("Lataaminen onnistui!");

            Inventory inventory = gameFile.getInventory();
            Home home = gameFile.getHome();

            for (Lutemon lutemon: home.getLutemons()) {
                System.out.println(" " + lutemon.getName());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Tiedoston lukemisessa tapahtui virhe!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Tiedoston lukemisessa tapahtui virhe!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Tiedoston lukemisessa tapahtui virhe!");
            e.printStackTrace();
        }
    }

    public GameFile getGameFile(){
        if (gameFile!=null){
            return gameFile;
        }
        return GameFile.getInstance();

    }

    public void setGameFile(GameFile gameFile) {
        this.gameFile = gameFile;
    }
}
