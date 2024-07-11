package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EnemyEnum;

/**
 * Represents an Ice Wraith enemy in the game, extending the abstract Enemy class.
 */
public class IceWraith extends Enemy {

    /**
     * Constructs an Ice Wraith enemy using default values from EnemyEnum.
     */
    public IceWraith() {
        this(EnemyEnum.ICE_WRAITH);
    }

    /**
     * Constructs an Ice Wraith enemy using values from an EnemyEnum.
     *
     * @param enemyEnum The EnemyEnum containing values for initialization.
     */
    public IceWraith(EnemyEnum enemyEnum) {
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
     * Calculates the attack damage of the Ice Wraith.
     *
     * @return The calculated attack damage.
     */
    @Override
    public int calculateAttackDamage() {
        return (int) (this.getStrength() * 1.4 + this.getLevel() * 1.6);
    }

    /**
     * Calculates the damage of a specific skill used by the Ice Wraith.
     *
     * @param skill The skill used to calculate damage.
     * @return The calculated damage of the skill.
     */
    @Override
    public int calculateSkillDamage(Skill skill) {
        return (int) (skill.getBaseDamage() + this.getIntelligence() * 1.1 + this.getLevel() * 1.9);
    }

    /**
     * Calculates the critical chance of the Ice Wraith.
     *
     * @return The calculated critical chance (as a percentage).
     */
    @Override
    public double calculateCriticalChance() {
        return this.getAgility() * 0.06 + this.getLevel() * 0.12;
    }

    /**
     * Returns a string representation of the Ice Wraith enemy.
     *
     * @return A string representation including all attributes of the Ice Wraith.
     */
    @Override
    public String toString() {
        return "IceWraith{" +
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
