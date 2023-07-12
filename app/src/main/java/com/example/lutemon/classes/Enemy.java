package com.example.lutemon.classes;

import java.util.ArrayList;

public class Enemy {
    private String name;
    private double difficultyMultiplier;
    private ArrayList<Lutemon> lutemons;

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public Enemy(String name, double multiplier, int numOfEnemies){
        this.name = name;
        this.difficultyMultiplier = multiplier;
        this.lutemons = generateLutemons(numOfEnemies);
    }

    public ArrayList<Lutemon> generateLutemons(int numberOfEnemies){
        ArrayList<Lutemon> generatedLutemons = new ArrayList<>();
        for(int i = 0; i<numberOfEnemies; i++){
            String name = "Enemy " + (i+1);
            Lutemon lutemon = new Lutemon("Normal","Enemy ");
            lutemon.setMaxHealth(14);
            generatedLutemons.add(lutemon);
        }
        return generatedLutemons;
    }

}
