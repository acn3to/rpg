package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.List;

public class Mage extends Character {
    private int manaRegenRate;

    public Mage(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, int manaRegenRate) {
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

        this.manaRegenRate = manaRegenRate;
        initializeRoleAttributes();
        addAttributesFromItems();
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        getItems().forEach(item -> {
            String effect = item.getEffect();
            int effectValue = item.getEffectBuff();

            switch (effect) {
                case "Mana Regeneration":
                    this.manaRegenRate += effectValue;
                    break;
            }
        });
    }

    @Override
    public int calculateAttackDamage() {
        int baseDamage = getIntelligencePoints() * 3;

        int manaRegenRate = getManaRegenRate();
        baseDamage += manaRegenRate;

        return baseDamage;
    }

    @Override
    public int calculateSkillDamage(SkillEnum skill) {
        switch (skill) {
            case GLACIAL_SPIKE:
                int baseDamage = getIntelligencePoints() * 3;


                return baseDamage;
            default:
                throw new IllegalArgumentException("Skill not supported for Mage: " + skill);
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
