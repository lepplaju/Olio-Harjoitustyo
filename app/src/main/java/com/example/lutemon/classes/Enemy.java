package com.example.lutemon.classes;

import com.example.lutemon.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Enemy implements Serializable {
    private int trainerLevel;
    private boolean isTrainer;
    private String name;
    private double difficultyMultiplier;
    private ArrayList<Lutemon> lutemons;

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public Enemy(String name, double multiplier, boolean isTrainer) {
        this.name = name;
        this.difficultyMultiplier = multiplier;
        //this.lutemons = generateDefaultLutemons(numOfEnemies);
        this.isTrainer = isTrainer;
    }

    public Enemy(String name, double multiplier, boolean isTrainer, int trainerLevel) {
        this.name = name;
        this.difficultyMultiplier = multiplier;
        this.trainerLevel = trainerLevel;
        this.isTrainer = isTrainer;
    }

    public void setLutemons(ArrayList<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    public boolean getIsTrainer() {
        return isTrainer;
    }

    public int getTrainerLevel() {
        return trainerLevel;
    }

    public Lutemon createEnemyLutemon(String name, int level, String type, int image) {
        Lutemon lutemon = new Lutemon(type, name);
        lutemon.setEnemyDefaultMoves();
        int min = 5 * level;
        int max = 10 * level;
        Random random = new Random();

        lutemon.setAttack(random.nextInt(max - min + 1) + min);
        lutemon.setDefence(random.nextInt(max - min + 1) + min);
        lutemon.setSpeed(random.nextInt(max - min + 1) + min);
        lutemon.setMaxHealth(random.nextInt(max - min + 1) + min);
        lutemon.setImage(image);

        return lutemon;
    }


}
