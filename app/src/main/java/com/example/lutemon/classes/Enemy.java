package com.example.lutemon.classes;

import com.example.lutemon.R;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    private boolean isTrainer;
    private String name;
    private double difficultyMultiplier;
    private ArrayList<Lutemon> lutemons;

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public Enemy(String name, double multiplier, int numOfEnemies) {
        this.name = name;
        this.difficultyMultiplier = multiplier;
        this.lutemons = generateLutemons(numOfEnemies);
    }

    public ArrayList<Lutemon> generateLutemons(int numberOfEnemies) {
        ArrayList<Lutemon> generatedLutemons = new ArrayList<>();
        for (int i = 0; i < numberOfEnemies; i++) {
            String name = "Enemy " + (i + 1);
            Lutemon lutemon = makeEnemy(name);
            generatedLutemons.add(lutemon);
        }
        return generatedLutemons;
    }

    public boolean getIsTrainer() {
        return isTrainer;
    }

    public Lutemon makeEnemy(String name) {
        Lutemon lutemon = new Lutemon("Normal", name);
        lutemon.setEnemyDefaultMoves();
        int min = 5;
        int max = 10;
        Random random = new Random();

        lutemon.setAttack(random.nextInt(max - min + 1) + min);
        lutemon.setDefence(random.nextInt(max - min + 1) + min);
        lutemon.setSpeed(random.nextInt(max - min + 1) + min);
        lutemon.setMaxHealth(random.nextInt(max - min + 1));
        lutemon.setImage(R.drawable.enemymonster1);

        return lutemon;
    }

}
