package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

/**
 * Represents an Assassin character in the RPG game.
 */
public class Assassin extends Character {
    private int poisonDamage;

    /**
     * Constructs an Assassin character with specified attributes.
     *
     * @param name         The name of the Assassin.
     * @param description  The description of the Assassin.
     * @param level        The level of the Assassin.
     * @param xpPoints     The experience points of the Assassin.
     * @param items        The list of items carried by the Assassin.
     * @param poisonDamage The poison damage inflicted by the Assassin.
     * @throws IllegalArgumentException if any of the parameters are invalid or null.
     */
    public Assassin(String name, String description, int level, int xpPoints, List<Item> items, int poisonDamage) {
        super(name, description, level, xpPoints, items, RoleEnum.ASSASSIN);

        if (poisonDamage < 0) {
            throw new IllegalArgumentException("Poison damage cannot be negative.");
        }
        this.poisonDamage = poisonDamage;
        addAttributesFromItems();
    }

    /**
     * Adds attribute bonuses from equipped items, including poison damage.
     */
    @Override
    protected void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectBuff = item.getEffectBuff();

            if ("Poison Damage".equals(effect)) {
                this.poisonDamage += effectBuff;
            }
        }
    }

    /**
     * Calculates the attack damage of the Assassin, considering poison damage.
     *
     * @return The calculated attack damage.
     */
    @Override
    public int calculateAttackDamage() {
        return getStrengthPoints() * 2 + getPoisonDamage();
    }

    /**
     * Retrieves the critical hit chance of the Assassin.
     *
     * @return The critical hit chance.
     */
    @Override
    public double calculateCriticalChance() {
        return 0.7;
    }

    /**
     * Calculates the skill damage of the Assassin using a specific skill.
     *
     * @param skill The skill to calculate damage for.
     * @return The calculated skill damage.
     * @throws IllegalArgumentException if the skill is not supported for the Assassin.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        int baseDamage;
        double criticalChance = calculateCriticalChance() / 100.0;
        double damageMultiplier = 1.0;

        switch (skill.getName()) {
            case "Venomous Strike":
                baseDamage = getStrengthPoints() * 2 + getPoisonDamage();
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }
                break;
            case "Back-stab":
                baseDamage = getAgilityPoints() * 3;
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }
                break;
            default:
                throw new IllegalArgumentException("Skill not supported for Assassin: " + skill.getName());
        }

        return (int) (baseDamage * damageMultiplier);
    }

    /**
     * Retrieves the poison damage of the Assassin.
     *
     * @return The poison damage.
     */
    public int getPoisonDamage() {
        return this.poisonDamage;
    }

    /**
     * Sets the poison damage of the Assassin.
     *
     * @param poisonDamage The new poison damage.
     * @throws IllegalArgumentException if the poison damage is negative.
     */
    public void setPoisonDamage(int poisonDamage) {
        if (poisonDamage < 0) {
            throw new IllegalArgumentException("Poison damage cannot be negative.");
        }
        this.poisonDamage = poisonDamage;
    }

    /**
     * Returns a string representation of the Assassin character.
     *
     * @return A string representation of the Assassin character.
     */
    @Override
    public String toString() {
        return "Assassin{" +
                "poisonDamage=" + getPoisonDamage() +
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
