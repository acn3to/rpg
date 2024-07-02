package com.skyrim.rpg.domain.entities;

import java.util.List;

public class Assassin extends Character {
    private int poisonDamage;

    public Assassin(String id, String name, String description, int level, int xpPoints, int healthPoints, int strengthPoints, int defensePoints, int agilityPoints, int intelligencePoints, int manaPoints, int staminaPoints, List<Item> items, List<Skill> skills, int poisonDamage) {
        super(id, name, description, level, xpPoints, healthPoints, strengthPoints, defensePoints, agilityPoints, intelligencePoints, manaPoints, staminaPoints, items, skills);
        this.poisonDamage = poisonDamage;
    }

    public int getPoisonDamage() {
        return poisonDamage;
    }

    public void setPoisonDamage(int poisonDamage) {
        this.poisonDamage = poisonDamage;
    }

    @Override
    public String toString() {
        return "Assassin{" +
                "poisonDamage=" + getPoisonDamage() +
                '}';
    }
}
