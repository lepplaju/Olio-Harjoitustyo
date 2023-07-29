package com.example.lutemon.uniqueLutemonTypes;

import com.example.lutemon.R;
import com.example.lutemon.classes.Lutemon;

import java.util.Random;

public class GrassLutemon extends Lutemon {
    public GrassLutemon(String name) {

        super("Grass", name,5);
        int min = 7;
        int max = 13;
        Random random= new Random();

        setAttack(random.nextInt(max-min+1) + min);
        setDefence(random.nextInt(max-min+1) + min);
        setSpeed(random.nextInt(max-min+1) + min);
        setMaxHealth(random.nextInt(max-min+1) + min);
        setImage(R.drawable.grassmonster);
    }
}
