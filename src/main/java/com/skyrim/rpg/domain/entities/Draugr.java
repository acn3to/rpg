package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EnemyEnum;

/**
 * Represents a Draugr enemy in the game, extending the abstract Enemy class.
 */
public class Draugr extends Enemy {

    /**
     * Constructs a Draugr enemy using default values from EnemyEnum.
     */
    public Draugr() {
        this(EnemyEnum.DRAUGR);
    }

    /**
     * Constructs a Draugr enemy using values from an EnemyEnum.
     *
     * @param enemyEnum The EnemyEnum containing values for initialization.
     */
    public Draugr(EnemyEnum enemyEnum) {
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
     * Calculates the attack damage of the Draugr.
     *
     * @return The calculated attack damage.
     */
    @Override
    public int calculateAttackDamage() {
        return (int) (this.getStrength() * 1.6 + this.getLevel() * 2.1);
    }

    /**
     * Calculates the damage of a specific skill used by the Draugr.
     *
     * @param skill The skill used to calculate damage.
     * @return The calculated damage of the skill.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        return (int) (skill.getBaseDamage() + this.getIntelligence() * 1.3 + this.getLevel() * 2.0);
    }

    /**
     * Calculates the critical chance of the Draugr.
     *
     * @return The calculated critical chance (as a percentage).
     */
    @Override
    public double calculateCriticalChance() {
        return this.getAgility() * 0.05 + this.getLevel() * 0.1;
    }

    /**
     * Returns a string representation of the Draugr enemy.
     *
     * @return A string representation including all attributes of the Draugr.
     */
    @Override
    public String toString() {
        return "Draugr{" +
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
