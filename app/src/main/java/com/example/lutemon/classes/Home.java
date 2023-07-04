package com.example.lutemon.classes;

public class Home extends Storage{
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
        lutemons.add(lutemon);
    }
}
