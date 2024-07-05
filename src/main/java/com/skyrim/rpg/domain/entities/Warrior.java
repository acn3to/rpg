package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.List;

public class Warrior extends Character {
    private int ragePoints;

    public Warrior(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, int ragePoints) {
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

        this.ragePoints = ragePoints;
        initializeRoleAttributes();
        addAttributesFromItems();
    }


    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        getItems().forEach(item -> {
            String effect = item.getEffect();
            int effectBuff = item.getEffectBuff();

            switch (effect) {
                case "Rage Points":
                    this.ragePoints += effectBuff;
                    break;
            }
        });
    }

    @Override
    public int calculateAttackDamage() {
        int baseDamage = getStrengthPoints() * 3;
        int ragePoints = getRagePoints();

        baseDamage += ragePoints;

        return baseDamage;
    }

    @Override
    public int calculateSkillDamage(SkillEnum skill) {
        switch (skill) {
            case THUNDEROUS_BLOW:
                int baseDamage = getStrengthPoints() * 3;
                int ragePoints = getRagePoints();
                //TODO: Add effects ragePoints based

                return baseDamage;
            default:
                throw new IllegalArgumentException("Skill not supported for Warrior: " + skill);
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
