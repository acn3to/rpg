package com.skyrim.rpg.domain.entities;

import java.util.List;

public class Mage extends Character{
    private int manaRegenRate;

    public Mage(String id, String name, String description, int level, int xpPoints, int healthPoints, int strengthPoints, int defensePoints, int agilityPoints, int intelligencePoints, int manaPoints, int staminaPoints, List<Item> items, List<Skill> skills, int manaRegenRate) {
        super(id, name, description, level, xpPoints, healthPoints, strengthPoints, defensePoints, agilityPoints, intelligencePoints, manaPoints, staminaPoints, items, skills);
        this.manaRegenRate = manaRegenRate;
    }

    public int getManaRegenRate() {
        return manaRegenRate;
    }

    public void setManaRegenRate(int manaRegenRate) {
        this.manaRegenRate = manaRegenRate;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "manaRegenRate=" + getManaRegenRate() +
                '}';
    }
}
