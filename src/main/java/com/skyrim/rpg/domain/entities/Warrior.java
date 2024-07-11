package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

/**
 * Represents a Warrior character in the RPG game.
 */
public class Warrior extends Character {
    private int ragePoints;

    /**
     * Constructs a Warrior character with specified attributes.
     *
     * @param name        The name of the Warrior.
     * @param description The description of the Warrior.
     * @param level       The level of the Warrior.
     * @param xpPoints    The experience points of the Warrior.
     * @param items       The list of items carried by the Warrior.
     * @param ragePoints  The rage points of the Warrior.
     * @throws IllegalArgumentException if any of the parameters are invalid or null.
     */
    public Warrior(String name, String description, int level, int xpPoints, List<Item> items, int ragePoints) {
        super(name, description, level, xpPoints, items, RoleEnum.WARRIOR);

        if (ragePoints < 0) {
            throw new IllegalArgumentException("Rage points cannot be negative.");
        }
        this.ragePoints = ragePoints;
        addAttributesFromItems();
    }

    /**
     * Adds attribute bonuses from equipped items, including rage points.
     */
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

    /**
     * Calculates the attack damage of the Warrior, considering strength points and rage points.
     *
     * @return The calculated attack damage.
     */
    @Override
    public int calculateAttackDamage() {
        int baseDamage = getStrengthPoints() * 3;
        baseDamage += getRagePoints();
        return baseDamage;
    }

    /**
     * Retrieves the critical hit chance of the Warrior.
     *
     * @return The critical hit chance.
     */
    @Override
    public double calculateCriticalChance() {
        return 0.3;
    }

    /**
     * Calculates the skill damage of the Warrior using a specific skill.
     *
     * @param skill The skill to calculate damage for.
     * @return The calculated skill damage.
     * @throws IllegalArgumentException if the skill is not supported for the Warrior.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        int baseDamage;
        double criticalChance = calculateCriticalChance() / 100.0;
        double damageMultiplier = 1.0;

        switch (skill.getName()) {
            case "Thunderous Blow":
                baseDamage = getStrengthPoints() * 3;
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }
                break;
            case "Berserk Rage":
                baseDamage = getStrengthPoints() * 2 + getRagePoints();
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }
                break;
            case "Slash":
                baseDamage = skill.getBaseDamage() + getStrengthPoints();
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }
                break;
            default:
                throw new IllegalArgumentException("Skill not supported for Warrior: " + skill.getName());
        }

        return (int) (baseDamage * damageMultiplier);
    }

    /**
     * Retrieves the rage points of the Warrior.
     *
     * @return The rage points.
     */
    public int getRagePoints() {
        return this.ragePoints;
    }

    /**
     * Sets the rage points of the Warrior.
     *
     * @param ragePoints The new rage points.
     * @throws IllegalArgumentException if the rage points are negative.
     */
    public void setRagePoints(int ragePoints) {
        if (ragePoints < 0) {
            throw new IllegalArgumentException("Rage points cannot be negative.");
        }
        this.ragePoints = ragePoints;
    }

    /**
     * Returns a string representation of the Warrior character.
     *
     * @return A string representation of the Warrior character.
     */
    @Override
    public String toString() {
        return "Warrior{" +
                "ragePoints=" + getRagePoints() +
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
