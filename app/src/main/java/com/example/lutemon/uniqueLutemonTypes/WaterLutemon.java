package com.example.lutemon.uniqueLutemonTypes;

import com.example.lutemon.classes.Lutemon;

import java.util.Random;

public class WaterLutemon extends Lutemon {
    public WaterLutemon(String name) {

        super("Water", name);
        int min = 6;
        int max = 14;
        Random random= new Random();

        setAttack(random.nextInt(max-min+1) + min);
        setDefence(random.nextInt(max-min+1) + min);
        setSpeed(random.nextInt(max-min+1) + min);
        setMaxHealth(random.nextInt(max-min+1) + min);

    }

}
