package com.example.lutemon.classes;

public class Lutemon {
    private String name;
    private String type;
    private int attack = 0;
    private int defence = 0;
    private int experience = 0;
    private int health = 0;
    private int maxHealth = 0;
    private int id;

    public Lutemon(String type, String name){
        this.type = type;
        this.name = name;
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
}


