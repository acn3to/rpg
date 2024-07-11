package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

/**
 * Represents an Archer character in the RPG game.
 */
public class Archer extends Character {
    private int criticalHitChance;

    /**
     * Constructs an Archer character with specified attributes.
     *
     * @param name              The name of the Archer.
     * @param description       The description of the Archer.
     * @param level             The level of the Archer.
     * @param xpPoints          The experience points of the Archer.
     * @param items             The list of items carried by the Archer.
     * @param criticalHitChance The critical hit chance of the Archer.
     * @throws IllegalArgumentException if any of the parameters are invalid or null.
     */
    public Archer(String name, String description, int level, int xpPoints, List<Item> items, int criticalHitChance) {
        super(name, description, level, xpPoints, items, RoleEnum.ARCHER);

        if (criticalHitChance < 0) {
            throw new IllegalArgumentException("Critical hit chance cannot be negative.");
        }

        this.criticalHitChance = criticalHitChance;
        addAttributesFromItems();
    }

    /**
     * Adds attribute bonuses from equipped items, including critical hit chance.
     */
    @Override
    protected void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            String effect = item.getEffect();
            int effectBuff = item.getEffectBuff();

            if ("Critical Hit Chance".equals(effect)) {
                this.criticalHitChance += effectBuff;
            }
        }
    }

    /**
     * Calculates the attack damage of the Archer, considering critical hit chance.
     *
     * @return The calculated attack damage.
     */
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

    /**
     * Retrieves the critical hit chance of the Archer.
     *
     * @return The critical hit chance.
     */
    @Override
    public double calculateCriticalChance() {
        return getCriticalHitChance();
    }

    /**
     * Calculates the skill damage of the Archer using a specific skill, considering critical hit chance.
     *
     * @param skill The skill to calculate damage for.
     * @return The calculated skill damage.
     * @throws IllegalArgumentException if the skill is not supported for the Archer.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        int baseDamage;
        double criticalChance = getCriticalHitChance() / 100.0;
        double damageMultiplier = 1.0;

        switch (skill.getName()) {
            case "Precision Shot":
                baseDamage = getAgilityPoints() * 2;
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }
                break;
            case "Fire Arrow":
                baseDamage = (int)(getAgilityPoints() * 1.5 + getIntelligencePoints());
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.5;
                }
                break;
            case "Rapid Shot":
                baseDamage = getAgilityPoints() * 2;
                if (Math.random() <= criticalChance) {
                    damageMultiplier = 1.3;
                }
                break;
            default:
                throw new IllegalArgumentException("Skill not supported for Archer: " + skill.getName());
        }

        return (int) (baseDamage * damageMultiplier);
    }

    /**
     * Retrieves the critical hit chance of the Archer.
     *
     * @return The critical hit chance.
     */
    public int getCriticalHitChance() {
        return this.criticalHitChance;
    }

    /**
     * Sets the critical hit chance of the Archer.
     *
     * @param criticalHitChance The new critical hit chance.
     * @throws IllegalArgumentException if the critical hit chance is negative.
     */
    public void setCriticalHitChance(int criticalHitChance) {
        if (criticalHitChance < 0) {
            throw new IllegalArgumentException("Critical hit chance cannot be negative.");
        }
        this.criticalHitChance = criticalHitChance;
    }

    /**
     * Returns a string representation of the Archer character.
     *
     * @return A string representation of the Archer character.
     */
    @Override
    public String toString() {
        return "Archer{" +
                "id='" + getId() + '\'' +
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
                ", roleType=" + getRoleType() +
                ", criticalHitChance=" + getCriticalHitChance() +
                '}';
    }
}
