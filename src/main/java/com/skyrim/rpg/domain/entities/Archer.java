package com.skyrim.rpg.domain.entities;

import java.util.List;

public class Archer extends Character{
    private double criticalHitChance;

    public Archer(String id, String name, String description, int level, int xpPoints, int healthPoints, int strengthPoints, int defensePoints, int agilityPoints, int intelligencePoints, int manaPoints, int staminaPoints, List<Item> items, List<Skill> skills, double criticalHitChance) {
        super(id, name, description, level, xpPoints, healthPoints, strengthPoints, defensePoints, agilityPoints, intelligencePoints, manaPoints, staminaPoints, items, skills);
        this.criticalHitChance = criticalHitChance;
    }

    public double getCriticalHitChance() {
        return criticalHitChance;
    }

    public void setCriticalHitChance(double criticalHitChance) {
        this.criticalHitChance = criticalHitChance;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "criticalHitChance=" + getCriticalHitChance() +
                '}';
    }
}
