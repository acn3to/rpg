package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EnemyEnum;

/**
 * Represents a Goblin enemy in the game, extending the abstract Enemy class.
 */
public class Goblin extends Enemy {

    /**
     * Constructs a Goblin enemy using default values from EnemyEnum.
     */
    public Goblin() {
        this(EnemyEnum.GOBLIN);
    }

    /**
     * Constructs a Goblin enemy using values from an EnemyEnum.
     *
     * @param enemyEnum The EnemyEnum containing values for initialization.
     */
    public Goblin(EnemyEnum enemyEnum) {
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
     * Calculates the attack damage of the Goblin.
     *
     * @return The calculated attack damage.
     */
    @Override
    public int calculateAttackDamage() {
        return (int) (this.getStrength() * 1.2 + this.getLevel() * 1.5);
    }

    /**
     * Calculates the damage of a specific skill used by the Goblin.
     *
     * @param skill The skill used to calculate damage.
     * @return The calculated damage of the skill.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        return (int) (skill.getBaseDamage() + this.getAgility() * 1.1 + this.getLevel() * 1.5);
    }

    /**
     * Calculates the critical chance of the Goblin.
     *
     * @return The calculated critical chance (as a percentage).
     */
    @Override
    public double calculateCriticalChance() {
        return this.getAgility() * 0.04 + this.getLevel() * 0.08;
    }

    /**
     * Returns a string representation of the Goblin enemy.
     *
     * @return A string representation including all attributes of the Goblin.
     */
    @Override
    public String toString() {
        return "Goblin{" +
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
