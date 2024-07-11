package com.skyrim.rpg.domain.entities;

import java.util.List;

/**
 * Represents an abstract base class for enemy entities in the game.
 */
public abstract class Enemy {
    private String name;
    private String description;
    private int level;
    private int healthPoints;
    private int maxHealthPoints;
    private int strength;
    private int defense;
    private int agility;
    private int intelligence;
    private int mana;
    private int stamina;
    private String type;
    private int xpRewards;
    private List<Skill> skills;

    /**
     * Constructs an enemy with specified attributes.
     *
     * @param name           The name of the enemy.
     * @param description    The description of the enemy.
     * @param level          The level of the enemy.
     * @param healthPoints   The current health points of the enemy.
     * @param maxHealthPoints The maximum health points of the enemy.
     * @param strength       The strength attribute of the enemy.
     * @param defense        The defense attribute of the enemy.
     * @param agility        The agility attribute of the enemy.
     * @param intelligence   The intelligence attribute of the enemy.
     * @param mana           The mana attribute of the enemy.
     * @param stamina        The stamina attribute of the enemy.
     * @param type           The type of the enemy.
     * @param xpRewards      The XP rewards given when the enemy is defeated.
     * @param skills         The list of skills the enemy possesses.
     */
    public Enemy(String name, String description, int level, int healthPoints, int maxHealthPoints, int strength, int defense, int agility,
                 int intelligence, int mana, int stamina, String type, int xpRewards, List<Skill> skills) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.intelligence = intelligence;
        this.mana = mana;
        this.stamina = stamina;
        this.type = type;
        this.xpRewards = xpRewards;
        this.skills = skills;
    }

    /**
     * Calculates the attack damage of the enemy.
     *
     * @return The calculated attack damage.
     */
    public abstract int calculateAttackDamage();

    /**
     * Calculates the damage of a specific skill used by the enemy.
     *
     * @param skill The skill used to calculate damage.
     * @return The calculated damage of the skill.
     */
    public abstract int calculateSkillDamage(Skill skill);

    /**
     * Calculates the critical chance of the enemy.
     *
     * @return The calculated critical chance (as a percentage).
     */
    public abstract double calculateCriticalChance();

    // Getters and setters for all attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getXpRewards() {
        return xpRewards;
    }

    public void setXpRewards(int xpRewards) {
        this.xpRewards = xpRewards;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Enemy{" +
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
