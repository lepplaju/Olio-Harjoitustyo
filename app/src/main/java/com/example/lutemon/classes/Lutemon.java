package com.example.lutemon.classes;

public class Lutemon {
    private static int STARTING_LEVEL = 5;
    private int level;
    private String name;
    private String type;
    private int attack = 1;
    private int defence = 1;
    private int experience = 1;
    private int health = 1;
    private int speed = 0;
    private int maxHealth = 1;
    private int id;

    public Lutemon(String type, String name) {
        this.type = type;
        this.name = name;
        this.level = STARTING_LEVEL;
    }

    public Lutemon(String type, String name, int attack, int defence, int maxHp, int exp) {
        this.type = type;
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = maxHp;
        this.health = maxHp;
        this.experience = exp;
    }

    public void defence(Lutemon lutemon) {

    }

    public int attack() {
        return 0;
    }

    public int getNumberOfCreatedLutemons() {
        return 0;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
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
}


