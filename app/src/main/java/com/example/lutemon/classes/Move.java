package com.example.lutemon.classes;

import java.io.Serializable;
import java.util.Random;

public class Move implements Serializable {
    private String name;
    private int baseDmg;
    private int accuracy;

    public String getName() {
        return name;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Move(String name, int baseDmg, int accuracy) {
        this.name = name;
        this.baseDmg = baseDmg;
        this.accuracy = accuracy;
    }

    // In this method we calculate the damage a certain move causes.
    // Takes in to account things such as critical strikes, type effectiveness, attacker's attack stat and target's defence stat.
    public int calculateDmg(int attackStat, int targetDefence, int accuracy, int effectiveness) {
        double criticalHitMultiplier = 1.5;
        int dmg = (int) ((attackStat * baseDmg) / targetDefence);

        if (isCriticalHit()) {
            dmg *= criticalHitMultiplier;
        }
        dmg *= effectiveness;

        if (isAttackSuccessful(accuracy)) {
            return dmg;
        }

        return 0; // Attack misses

    }

// Calculate the chance of a criticalHit (int @criticalChance tells the odd (percentage) of hitting the critical strike)
    private boolean isCriticalHit() {
        int criticalChance = 2;
        int randomNumber = new Random().nextInt(101);
        return randomNumber < criticalChance;
    }

    // With accuracy of 100, an attack never fails. This one also uses percentages to calculate the odds.
    private boolean isAttackSuccessful(int accuracy){
        int randomNumber = new Random().nextInt(101);
        return randomNumber <= accuracy;
    }
}
