package com.example.lutemon.classes;

public class Lutemon {
    private String name;
    private String type;
    private int attack = 1;
    private int defence = 1;
    private int experience = 1;
    private int health = 1;
    private int maxHealth = 1;
    private int id;

    public Lutemon(String type, String name){
        this.type = type;
        this.name = name;
    }
    public Lutemon(String type, String name, int attack, int defence, int hp, int exp){
        this.type= type;
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.health = hp;
        this.experience = exp;
    }

    public void defence(Lutemon lutemon){

    }

    public int attack(){
        return 0;
    }

    public int getNumberOfCreatedLutemons(){
        return 0;
    }
    public String getType(){
        return type;
    }
    public String getName(){
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

    public int getHealth() {
        return health;
    }
}


