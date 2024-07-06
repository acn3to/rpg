package com.skyrim.rpg.domain.entities;

import java.util.List;

public class Warrior extends Character {
    private int ragePoints;

    public Warrior(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, String roleType, int ragePoints) {
        super(name, description, level, xpPoints, items, skills, roleType);

        if (level < 1) {
            throw new IllegalArgumentException("Level must be greater than or equal to 1.");
        }

        if (xpPoints < 0) {
            throw new IllegalArgumentException("XP points cannot be negative.");
        }

        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Items list must be provided and not empty.");
        }

        if (skills == null || skills.isEmpty()) {
            throw new IllegalArgumentException("Skills list must be provided and not empty.");
        }

        this.ragePoints = ragePoints;
        initializeRoleAttributes(roleType);
        addAttributesFromItems();
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectBuff = item.getEffectBuff();

            if ("Rage Points".equals(effect)) {
                this.ragePoints += effectBuff;
            }
        }
    }

    @Override
    public int calculateAttackDamage() {
        int baseDamage = getStrengthPoints() * 3;
        int ragePoints = getRagePoints();

        baseDamage += ragePoints;

        return baseDamage;
    }

    @Override
    public int calculateSkillDamage(Skill skill) {
        if ("Thunderous Blow".equals(skill.getName())) {
            int baseDamage = getStrengthPoints() * 3;
            int ragePoints = getRagePoints();

            return baseDamage;
        } else {
            throw new IllegalArgumentException("Skill not supported for Warrior: " + skill.getName());
        }
    }

    @Override
    public double calculateCriticalChance() {
        return 0.7;
    }

    public int getRagePoints() {
        return ragePoints;
    }

    public void setRagePoints(int ragePoints) {
        if (ragePoints < 0) {
            throw new IllegalArgumentException("Rage points cannot be negative.");
        }
        this.ragePoints = ragePoints;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "ragePoints=" + getRagePoints() +
                '}';
    }

}
