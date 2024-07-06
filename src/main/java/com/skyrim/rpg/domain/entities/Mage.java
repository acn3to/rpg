package com.skyrim.rpg.domain.entities;

import java.util.List;

public class Mage extends Character {
    private int manaRegenRate;

    public Mage(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, String roleType, int manaRegenRate) {
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

        if (manaRegenRate < 0) {
            throw new IllegalArgumentException("Mana regeneration rate cannot be negative.");
        }

        this.manaRegenRate = manaRegenRate;
        initializeRoleAttributes(roleType);
        addAttributesFromItems();
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectValue = item.getEffectBuff();

            if ("Mana Regeneration".equals(effect)) {
                this.manaRegenRate += effectValue;
            }
        }
    }

    @Override
    public int calculateAttackDamage() {
        int baseDamage = getIntelligencePoints() * 3;
        baseDamage += getManaRegenRate();
        return baseDamage;
    }

    @Override
    public int calculateSkillDamage(Skill skill) {
        if ("Glacial Spike".equals(skill.getName())) {
            return getIntelligencePoints() * 3;
        } else {
            throw new IllegalArgumentException("Skill not supported for Mage: " + skill.getName());
        }
    }

    @Override
    public double calculateCriticalChance() {
        return 0.3;
    }

    public int getManaRegenRate() {
        return manaRegenRate;
    }

    public void setManaRegenRate(int manaRegenRate) {
        if (manaRegenRate < 0) {
            throw new IllegalArgumentException("Mana regeneration rate cannot be negative.");
        }
        this.manaRegenRate = manaRegenRate;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "manaRegenRate=" + getManaRegenRate() +
                '}';
    }

}
