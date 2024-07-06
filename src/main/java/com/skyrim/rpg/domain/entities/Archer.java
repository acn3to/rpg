package com.skyrim.rpg.domain.entities;

import java.util.List;

public class Archer extends Character {
    private int criticalHitChance;

    public Archer(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, String roleType, int criticalHitChance) {
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

        if (roleType == null || roleType.isEmpty()) {
            throw new IllegalArgumentException("Role type must be provided.");
        }

        if (criticalHitChance < 0) {
            throw new IllegalArgumentException("Critical hit chance cannot be negative.");
        }

        this.criticalHitChance = criticalHitChance;
        initializeRoleAttributes(roleType);
        addAttributesFromItems();
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectBuff = (int) item.getEffectBuff();

            if ("Critical Hit Chance".equals(effect)) {
                setCriticalHitChance(getCriticalHitChance() + effectBuff);
            }
        }
    }

    @Override
    public int calculateAttackDamage() {
        int baseDamage = getStrengthPoints() * 2;
        double criticalChance = getCriticalHitChance() / 100.0;
        double damageMultiplier = 1.0;

        if (Math.random() <= criticalChance) {
            damageMultiplier = 1.5;
        }

        return (int) (baseDamage * damageMultiplier);
    }

    @Override
    public double calculateCriticalChance() {
        return getCriticalHitChance();
    }

    @Override
    public int calculateSkillDamage(Skill skill) {
        if ("Precision Shot".equals(skill.getName())) {
            int baseDamage = getAgilityPoints() * 2;
            double criticalChance = getCriticalHitChance() / 100.0;
            double damageMultiplier = 1.0;

            if (Math.random() <= criticalChance) {
                damageMultiplier = 1.5;
            }

            return (int) (baseDamage * damageMultiplier);
        } else {
            throw new IllegalArgumentException("Skill not supported for Archer: " + skill.getName());
        }
    }

    public int getCriticalHitChance() {
        return criticalHitChance;
    }

    public void setCriticalHitChance(int criticalHitChance) {
        if (criticalHitChance < 0) {
            throw new IllegalArgumentException("Critical hit chance cannot be negative.");
        }
        this.criticalHitChance = criticalHitChance;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "criticalHitChance=" + getCriticalHitChance() +
                '}';
    }
}