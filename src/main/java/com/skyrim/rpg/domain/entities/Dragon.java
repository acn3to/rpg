package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EnemyEnum;

/**
 * Represents a Dragon enemy in the game, extending the abstract Enemy class.
 */
public class Dragon extends Enemy {

    /**
     * Constructs a Dragon enemy using default values from EnemyEnum.
     */
    public Dragon() {
        this(EnemyEnum.DRAGON);
    }

    /**
     * Constructs a Dragon enemy using values from an EnemyEnum.
     *
     * @param enemyEnum The EnemyEnum containing values for initialization.
     */
    public Dragon(EnemyEnum enemyEnum) {
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
     * Calculates the attack damage of the Dragon.
     *
     * @return The calculated attack damage.
     */
    @Override
    public int calculateAttackDamage() {
        return (int) (this.getStrength() * 1.5 + this.getLevel() * 2);
    }

    /**
     * Calculates the damage of a specific skill used by the Dragon.
     *
     * @param skill The skill used to calculate damage.
     * @return The calculated damage of the skill.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        return (int) (skill.getBaseDamage() + this.getIntelligence() * 1.2 + this.getLevel() * 2);
    }

    /**
     * Calculates the critical chance of the Dragon.
     *
     * @return The calculated critical chance (as a percentage).
     */
    @Override
    public double calculateCriticalChance() {
        return this.getAgility() * 0.05 + this.getLevel() * 0.1;
    }

    /**
     * Returns a string representation of the Dragon enemy.
     *
     * @return A string representation including all attributes of the Dragon.
     */
    @Override
    public String toString() {
        return "Dragon{" +
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
