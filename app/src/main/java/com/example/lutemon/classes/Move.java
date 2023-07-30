package com.example.lutemon.classes;

import com.example.lutemon.adaptersAndHelpers.DamageResult;

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
    public DamageResult calculateDmg(int attackStat, int targetDefence, int accuracy, int effectiveness) {
        DamageResult dmgResult = new DamageResult();
        dmgResult.setMoveName(getName());
        if (!isAttackSuccessful(accuracy)) {
            return dmgResult;
        }
        dmgResult.setHit(true);
        double criticalHitMultiplier = 1.5;
        int dmg = (int) ((attackStat * this.baseDmg) / targetDefence);
        if ((attackStat * this.baseDmg) % targetDefence != 0) { // If a hit is successful, always hit at least 1
            dmg += 1;
        }
        if (isCriticalHit()) {
            dmg *= criticalHitMultiplier;
            dmgResult.setCriticalHit(true);
        }
        dmgResult.setEffectiveness(effectiveness);
        dmg *= effectiveness;


        dmgResult.setDamage(dmg);
        return dmgResult;

    }

    // Calculate the chance of a criticalHit (int @criticalChance tells the odd (percentage) of hitting the critical strike)
    private boolean isCriticalHit() {
        int criticalChance = 3;
        int randomNumber = new Random().nextInt(101);
        return randomNumber <= criticalChance;
    }

    // With accuracy of 100, an attack never fails. This one also uses percentages to calculate the odds.
    private boolean isAttackSuccessful(int accuracy) {
        int randomNumber = new Random().nextInt(101);
        return randomNumber <= accuracy;
    }
}
