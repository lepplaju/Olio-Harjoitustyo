package com.example.lutemon.classes;

import java.io.Serializable;

public class Inventory extends Storage implements Serializable {
    private static Inventory inventory;
    private Inventory(){
        super();
    }

    public static Inventory getInstance(){
        if(inventory==null){
            inventory = new Inventory();
        }
            return inventory;
    }

    public void moveLutemonToHome(Lutemon lutemon){
        Home home = Home.getInstance();
        lutemon.setLocation("Home");
        home.addLutemon(lutemon);
        lutemons.remove(lutemon);
    }
}
