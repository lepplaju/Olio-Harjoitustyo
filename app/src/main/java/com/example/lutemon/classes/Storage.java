package com.example.lutemon.classes;

import java.util.ArrayList;

public class Storage {
    protected String name;
    protected ArrayList<Lutemon> lutemons;

    public Storage(){
        name = "default";
        lutemons = new ArrayList<>();
    }
    public void addLutemon(Lutemon lutemon){

    }

    public Lutemon getLutemon(int id){
        return null;
    }
    public void listLutemons(){
        for (Lutemon lutemon: lutemons ) {
            System.out.println(lutemon.getName() + lutemon.getType());
        }
    }
}
