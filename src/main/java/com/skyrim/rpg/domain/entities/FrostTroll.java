package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EnemyEnum;

/**
 * Represents a Frost Troll enemy in the game, extending the abstract Enemy class.
 */
public class FrostTroll extends Enemy {

    /**
     * Constructs a Frost Troll enemy using default values from EnemyEnum.
     */
    public FrostTroll() {
        this(EnemyEnum.FROST_TROLL);
    }

    /**
     * Constructs a Frost Troll enemy using values from an EnemyEnum.
     *
     * @param enemyEnum The EnemyEnum containing values for initialization.
     */
    public FrostTroll(EnemyEnum enemyEnum) {
        super(
                enemyEnum.getName(),
                enemyEnum.getDescription(),
                enemyEnum.getLevel(),
                enemyEnum.getHealthPoints(),
                enemyEnum.getHealthPoints(),
                enemyEnum.getStrength(),
                enemyEnum.getDefense(),
                enemyEnum.getAgility(),
                enemyEnum.getIntelligence(),
                enemyEnum.getMana(),
                enemyEnum.getStamina(),
                enemyEnum.getType(),
                enemyEnum.getXpRewards(),
                enemyEnum.getSkills()
        );
    }

    /**
     * Calculates the attack damage of the Frost Troll.
     *
     * @return The calculated attack damage.
     */
    @Override
    public int calculateAttackDamage() {
        return (int) (this.getStrength() * 1.7 + this.getLevel() * 2.3);
    }

    /**
     * Calculates the damage of a specific skill used by the Frost Troll.
     *
     * @param skill The skill used to calculate damage.
     * @return The calculated damage of the skill.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        return (int) (skill.getBaseDamage() + this.getStrength() * 1.4 + this.getLevel() * 2.1);
    }

    /**
     * Calculates the critical chance of the Frost Troll.
     *
     * @return The calculated critical chance (as a percentage).
     */
    @Override
    public double calculateCriticalChance() {
        return this.getAgility() * 0.04 + this.getLevel() * 0.09;
    }

    /**
     * Returns a string representation of the Frost Troll enemy.
     *
     * @return A string representation including all attributes of the Frost Troll.
     */
    @Override
    public String toString() {
        return "FrostTroll{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", level=" + getLevel() +
                ", healthPoints=" + getHealthPoints() +
                ", maxHealthPoints=" + getMaxHealthPoints() +
                ", strength=" + getStrength() +
                ", defense=" + getDefense() +
                ", agility=" + getAgility() +
                ", intelligence=" + getIntelligence() +
                ", mana=" + getMana() +
                ", stamina=" + getStamina() +
                ", type='" + getType() + '\'' +
                ", xpRewards=" + getXpRewards() +
                ", skills=" + getSkills() +
                '}';
    }
}
