package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

/**
 * Represents a Mage character in the RPG game.
 */
public class Mage extends Character {
    private int manaRegenRate;

    /**
     * Constructs a Mage character with specified attributes.
     *
     * @param name          The name of the Mage.
     * @param description   The description of the Mage.
     * @param level         The level of the Mage.
     * @param xpPoints      The experience points of the Mage.
     * @param items         The list of items carried by the Mage.
     * @param manaRegenRate The mana regeneration rate of the Mage.
     * @throws IllegalArgumentException if any of the parameters are invalid or null.
     */
    public Mage(String name, String description, int level, int xpPoints, List<Item> items, int manaRegenRate) {
        super(name, description, level, xpPoints, items, RoleEnum.MAGE);

        if (manaRegenRate < 0) {
            throw new IllegalArgumentException("Mana regeneration rate cannot be negative.");
        }
        this.manaRegenRate = manaRegenRate;
        addAttributesFromItems();
    }

    /**
     * Adds attribute bonuses from equipped items, including mana regeneration rate.
     */
    @Override
    protected void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectBuff = item.getEffectBuff();

            if ("Mana Regeneration".equals(effect)) {
                this.manaRegenRate += effectBuff;
            }
        }
    }

    /**
     * Calculates the attack damage of the Mage, considering intelligence points and mana regeneration rate.
     *
     * @return The calculated attack damage.
     */
    @Override
    public int calculateAttackDamage() {
        return getIntelligencePoints() * 3 + getManaRegenRate();
    }

    /**
     * Retrieves the critical hit chance of the Mage.
     *
     * @return The critical hit chance.
     */
    @Override
    public double calculateCriticalChance() {
        return 0.3;
    }

    /**
     * Calculates the skill damage of the Mage using a specific skill.
     *
     * @param skill The skill to calculate damage for.
     * @return The calculated skill damage.
     * @throws IllegalArgumentException if the skill is not supported for the Mage.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        int baseDamage;
        double criticalChance = calculateCriticalChance() / 100.0;
        double damageMultiplier = 1.0;

        switch (skill.getName()) {
            case "Glacial Spike":
                baseDamage = getIntelligencePoints() * 3 + getManaRegenRate();
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }
                break;
            case "Fireball":
                baseDamage = getIntelligencePoints() * 2 + getManaPoints() / 2;
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.3;
                }
                break;
            case "Chain Lightning":
                baseDamage = getIntelligencePoints() + getManaRegenRate();
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.4;
                }
                break;
            default:
                throw new IllegalArgumentException("Skill not supported for Mage: " + skill.getName());
        }

        return (int) (baseDamage * damageMultiplier);
    }

    /**
     * Retrieves the mana regeneration rate of the Mage.
     *
     * @return The mana regeneration rate.
     */
    public int getManaRegenRate() {
        return this.manaRegenRate;
    }

    /**
     * Sets the mana regeneration rate of the Mage.
     *
     * @param manaRegenRate The new mana regeneration rate.
     * @throws IllegalArgumentException if the mana regeneration rate is negative.
     */
    public void setManaRegenRate(int manaRegenRate) {
        if (manaRegenRate < 0) {
            throw new IllegalArgumentException("Mana regeneration rate cannot be negative.");
        }
        this.manaRegenRate = manaRegenRate;
    }

    /**
     * Returns a string representation of the Mage character.
     *
     * @return A string representation of the Mage character.
     */
    @Override
    public String toString() {
        return "Mage{" +
                "manaRegenRate=" + getManaRegenRate() +
                ", id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", level=" + getLevel() +
                ", xpPoints=" + getXpPoints() +
                ", healthPoints=" + getHealthPoints() +
                ", strengthPoints=" + getStrengthPoints() +
                ", defensePoints=" + getDefensePoints() +
                ", agilityPoints=" + getAgilityPoints() +
                ", intelligencePoints=" + getIntelligencePoints() +
                ", manaPoints=" + getManaPoints() +
                ", staminaPoints=" + getStaminaPoints() +
                ", items=" + getItems() +
                ", skills=" + getSkills() +
                ", roleType='" + getRoleType() + '\'' +
                '}';
    }
}
