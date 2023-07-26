package com.example.lutemon.classes;

import android.os.Handler;

import com.example.lutemon.adaptersAndHelpers.ChatboxController;
import com.example.lutemon.adaptersAndHelpers.DamageResult;

import java.io.Serializable;
import java.util.ArrayList;

public class Lutemon implements Serializable {
    private static int STARTING_LEVEL = 5;
    private static int NUM_OF_MOVES = 4;
    private int image;
    private ArrayList<Move> moves;
    private String storageLocation;
    private int level;
    private String name;
    private String type;
    private int attack = 1;
    private int defence = 1;
    private int experience = 1;
    private int expToLevel = 10;
    private int health = 1;
    private int speed = 0;
    private int maxHealth = 1;
    private int id;

    public Lutemon(String type, String name) {
        this.type = type;
        this.name = name;
        this.level = STARTING_LEVEL;
        this.moves = setDefaultMoves();
    }

    public Lutemon(String type, String name, int attack, int defence, int maxHp, int exp) {
        this.type = type;
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = maxHp;
        this.health = maxHp;
        this.experience = exp;
        this.moves = setDefaultMoves();
    }


    public void defence(Lutemon lutemon) {

    }

    public DamageResult attack(Lutemon attackerLutemon, Lutemon targetLutemon, Move move) {
        DamageResult dmgCalculation = move.calculateDmg(attackerLutemon.getAttack(), targetLutemon.getDefence(), move.getAccuracy(), 1);
        targetLutemon.takeDamage(dmgCalculation.getDamage());
        return dmgCalculation;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void addMove(Move move) {
        if (moves.size() > NUM_OF_MOVES) {
            moves.add(move);
        } else {
            moves.set(NUM_OF_MOVES, move);
        }

    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public ArrayList<Move> setDefaultMoves() {
        ArrayList<Move> generatedMoves = new ArrayList<>();
        Move move1 = new Move("Punch", 5, 90);
        Move move2 = new Move("Kick", 9, 80);
        Move move3 = new Move("Hype-up", 0, 100);
        Move move4 = new Move(this.getType() + " blast", 6, 90);
        generatedMoves.add(move1);
        generatedMoves.add(move2);
        generatedMoves.add(move3);
        generatedMoves.add(move4);
        this.moves = generatedMoves;
        return generatedMoves;
    }

    public ArrayList<Move> setEnemyDefaultMoves() {
        ArrayList<Move> generatedMoves = new ArrayList<>();
        Move move1 = new Move("Tackle", 4, 90);
        Move move2 = new Move("Body-slam", 8, 80);
        Move move3 = new Move("Rage", 0, 100);
        Move move4 = new Move(this.getType() + " blast", 5, 90);
        generatedMoves.add(move1);
        generatedMoves.add(move2);
        generatedMoves.add(move3);
        generatedMoves.add(move4);
        this.moves = generatedMoves;
        return generatedMoves;
    }


    public int addExp(Lutemon enemyLutemon, Enemy enemy) {
        int baseExp = 10;
        baseExp *= enemyLutemon.getLevel();
        if (enemy.getIsTrainer()) {
            baseExp *= 2;
        }
        baseExp += enemyLutemon.getMaxHealth() / 2;

        this.experience += baseExp;
        return baseExp;
    }


    public void checkLevelUp(ChatboxController controller) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (expToLevel < experience) {
                    level++;
                    controller.setChatBoxText(name + " Levelled up to level " + getLevel() + "!");
                    controller.setLutemonLevelTV(getName() + " : level " + getLevel());
                    experience = experience - expToLevel;
                    expToLevel = (level - STARTING_LEVEL) * 10;
                    if (expToLevel < experience) {
                        checkLevelUp(controller);
                    } else {
                        controller.showExitBtn();
                    }
                } else {
                    controller.showExitBtn();
                }
            }
        }, 1000);

    }
}