package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.List;

public class Assassin extends Character {
    private int poisonDamage;

    public Assassin(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, int poisonDamage) {
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

        this.poisonDamage = poisonDamage;
        initializeRoleAttributes();
        addAttributesFromItems();
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectBuff = item.getEffectBuff();

            switch (effect) {
                case "Poison Damage":
                    setPoisonDamage(getPoisonDamage() + effectBuff);
                    break;
            }
        }
    }

    @Override
    public int calculateAttackDamage() {
        int baseDamage = getStrengthPoints() * 2;
        int poisonDamage = getPoisonDamage();

        baseDamage += poisonDamage;

        return baseDamage;
    }

    @Override
    public int calculateSkillDamage(SkillEnum skill) {
        switch (skill) {
            case VENOMOUS_STRIKE:
                int baseDamage = getStrengthPoints() * 2;
                int poisonDamage = getPoisonDamage();

                baseDamage += poisonDamage;

                return baseDamage;
            default:
                throw new IllegalArgumentException("Skill not supported for Assassin: " + skill);
        }
    }

    @Override
    public double calculateCriticalChance() {
        return 1.5;
    }

    public int getPoisonDamage() {
        return poisonDamage;
    }

    public void setPoisonDamage(int poisonDamage) {
        if (poisonDamage < 0) {
            throw new IllegalArgumentException("Poison damage cannot be negative.");
        }
        this.poisonDamage = poisonDamage;
    }

    @Override
    public String toString() {
        return "Assassin{" +
                "poisonDamage=" + getPoisonDamage() +
                '}';
    }
}
