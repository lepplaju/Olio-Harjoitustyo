package com.example.lutemon.classes;

public class Inventory extends Storage{
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
