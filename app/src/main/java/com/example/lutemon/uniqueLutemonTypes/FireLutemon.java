package com.example.lutemon.uniqueLutemonTypes;

import com.example.lutemon.R;
import com.example.lutemon.classes.Lutemon;

import java.util.Random;

public class FireLutemon extends Lutemon {
    public FireLutemon(String name) {

        super("Fire", name);
        int min = 5;
        int max = 15;
        Random random= new Random();

        setAttack(random.nextInt(max-min+1) + min);
        setDefence(random.nextInt(max-min+1) + min);
        setSpeed(random.nextInt(max-min+1) + min);
        setMaxHealth(random.nextInt(max-min+1) + min);
        setImage(R.drawable.firemonster);

    }
}
