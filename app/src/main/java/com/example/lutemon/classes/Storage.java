package com.example.lutemon.classes;

import com.example.lutemon.adaptersAndHelpers.LutemonViewHelper;

import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {
    protected String name;
    protected ArrayList<Lutemon> lutemons;

    public Storage() {
        name = "default";
        lutemons = new ArrayList<Lutemon>();
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public void listLutemons() {
        for (Lutemon lutemon : lutemons) {
            System.out.println(lutemon.getName() + lutemon.getType());
        }
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }


}
