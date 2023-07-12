package com.example.lutemon.classes;

public class Move {
    private String name;
    private int baseDmg;
    private int accuracy;

    public String getName() {
        return name;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Move(String name, int baseDmg, int accuracy){
        this.name = name;
        this.baseDmg = baseDmg;
        this.accuracy = accuracy;
    }
}
