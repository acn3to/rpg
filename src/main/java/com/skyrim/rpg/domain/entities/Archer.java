package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.List;

public class Archer extends Character {
    private int criticalHitChance;

    public Archer(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, int criticalHitChance) {
        super(name, description, level, xpPoints, items, skills, role);

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

        if (role == null) {
            throw new IllegalArgumentException("Role must be provided.");
        }

        if (criticalHitChance < 0) {
            throw new IllegalArgumentException("Critical hit chance cannot be negative.");
        }

        this.criticalHitChance = criticalHitChance;
        initializeRoleAttributes();
        addAttributesFromItems();
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectBuff = (int) item.getEffectBuff();

            switch (effect) {
                case "Critical Hit Chance":
                    setCriticalHitChance(getCriticalHitChance() + effectBuff);
                    break;
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
    public int calculateSkillDamage(SkillEnum skill) {
        switch (skill) {
            case PRECISION_SHOT:
                int baseDamage = getAgilityPoints() * 2;
                double criticalChance = getCriticalHitChance() / 100.0;
                double damageMultiplier = 1.0;

                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }

                return (int) (baseDamage * damageMultiplier);
            default:
                throw new IllegalArgumentException("Skill not supported for Archer: " + skill);
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
