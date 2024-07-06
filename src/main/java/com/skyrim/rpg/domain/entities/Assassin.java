package com.skyrim.rpg.domain.entities;

import java.util.List;

public class Assassin extends Character {
    private int poisonDamage;

    public Assassin(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, String roleType, int poisonDamage) {
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

        if (poisonDamage < 0) {
            throw new IllegalArgumentException("Poison damage cannot be negative.");
        }

        this.poisonDamage = poisonDamage;
        initializeRoleAttributes(roleType);
        addAttributesFromItems();
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectBuff = item.getEffectBuff();

            if ("Poison Damage".equals(effect)) {
                setPoisonDamage(getPoisonDamage() + effectBuff);
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
    public int calculateSkillDamage(Skill skill) {
        if ("Venomous Strike".equals(skill.getName())) {
            int baseDamage = getStrengthPoints() * 2;
            int poisonDamage = getPoisonDamage();

            baseDamage += poisonDamage;

            return baseDamage;
        } else {
            throw new IllegalArgumentException("Skill not supported for Assassin: " + skill.getName());
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
