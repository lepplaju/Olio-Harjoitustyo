package com.example.lutemon.adaptersAndHelpers;

public class DamageResult {
    private boolean hit;
    private boolean criticalHit;
    private String effectiveness;
    private int damage;

    private String moveName;

    public DamageResult() {
        this.hit = false;
        this.criticalHit = false;
        this.effectiveness = "Normal";
        this.damage = 0;
        this.moveName = "";
    }

    public DamageResult(boolean hit, boolean criticalHit, String effectiveness, int damage) {
        this.hit = hit;
        this.criticalHit = criticalHit;
        this.effectiveness = effectiveness;
        this.damage = damage;
    }

    public boolean isHit() {
        return hit;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public boolean isCriticalHit() {
        return criticalHit;
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public int getDamage() {
        return damage;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setCriticalHit(boolean criticalHit) {
        this.criticalHit = criticalHit;
    }

    public void setEffectiveness(int effectiveness) {
        if (effectiveness == 0) {
            setEffectiveness("Not very");
        } else if (effectiveness == 1) {
            setEffectiveness("Normal");
        } else if (effectiveness == 2) {
            setEffectiveness("Super");
        }
    }

    public void setEffectiveness(String effectiveness) {
        this.effectiveness = effectiveness;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


}
