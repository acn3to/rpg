package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Abstract class representing a character in the RPG game.
 */
public abstract class Character {
    private final String id;
    private String name;
    private String description;
    private int level;
    private int xpPoints;
    private int healthPoints;
    private int maxHealthPoints;
    private int strengthPoints;
    private int defensePoints;
    private int agilityPoints;
    private int intelligencePoints;
    private int manaPoints;
    private int staminaPoints;
    private List<Item> items;
    private List<Skill> skills;
    private RoleEnum roleType;

    /**
     * Constructs a character with specified attributes.
     *
     * @param name        The name of the character.
     * @param description The description of the character.
     * @param level       The level of the character.
     * @param xpPoints    The experience points of the character.
     * @param items       The list of items carried by the character.
     * @param roleType    The role type (class) of the character.
     * @throws IllegalArgumentException if any of the parameters are invalid or null.
     */
    public Character(String name, String description, int level, int xpPoints, List<Item> items, RoleEnum roleType) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name must be provided.");
        if (description == null || description.isEmpty()) throw new IllegalArgumentException("Description must be provided.");
        if (level < 1) throw new IllegalArgumentException("Level must be greater than or equal to 1.");
        if (xpPoints < 0) throw new IllegalArgumentException("XP points cannot be negative.");
        if (items == null) throw new IllegalArgumentException("Items list must be provided and not null.");
        if (roleType == null) throw new IllegalArgumentException("Role type must be provided.");

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.level = level;
        this.xpPoints = xpPoints;
        this.items = items;
        this.roleType = roleType;
        initializeRoleAttributes(roleType);
        addAttributesFromItems();
        initializeDefaultSkills();
        this.maxHealthPoints = this.healthPoints; // Initialize maxHealthPoints
    }

    /**
     * Initializes role-specific attributes based on the role type.
     *
     * @param roleType The role type (class) of the character.
     */
    protected void initializeRoleAttributes(RoleEnum roleType) {
        this.healthPoints = roleType.getHealth();
        this.strengthPoints = roleType.getStrength();
        this.defensePoints = roleType.getDefense();
        this.agilityPoints = roleType.getAgility();
        this.intelligencePoints = roleType.getIntelligence();
        this.manaPoints = roleType.getMana();
        this.staminaPoints = roleType.getStamina();
    }

    /**
     * Adds attribute bonuses from equipped items.
     */
    protected void addAttributesFromItems() {
        for (Item item : items) {
            String effect = item.getEffect();
            int effectBuff = item.getEffectBuff();

            switch (effect) {
                case "Health Points":
                    healthPoints += effectBuff;
                    break;
                case "Strength Points":
                    strengthPoints += effectBuff;
                    break;
                case "Defense Points":
                    defensePoints += effectBuff;
                    break;
                case "Agility Points":
                    agilityPoints += effectBuff;
                    break;
                case "Intelligence Points":
                    intelligencePoints += effectBuff;
                    break;
                case "Mana Points":
                    manaPoints += effectBuff;
                    break;
                case "Stamina Points":
                    staminaPoints += effectBuff;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Initializes default skills based on the character's role type.
     */
    protected void initializeDefaultSkills() {
        this.skills = new ArrayList<>(roleType.getDefaultSkills());
    }

    /**
     * Abstract method to calculate the attack damage of the character.
     *
     * @return The calculated attack damage.
     */
    public abstract int calculateAttackDamage();

    /**
     * Abstract method to calculate the skill damage of the character using a specific skill.
     *
     * @param skill The skill to calculate damage for.
     * @return The calculated skill damage.
     */
    public abstract int calculateSkillDamage(Skill skill);

    /**
     * Abstract method to calculate the critical hit chance of the character.
     *
     * @return The calculated critical hit chance.
     */
    public abstract double calculateCriticalChance();

    public String getId() {
        return id;
    }

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

    public int getXpPoints() {
        return xpPoints;
    }

    public void setXpPoints(int xpPoints) {
        this.xpPoints = xpPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrengthPoints() {
        return strengthPoints;
    }

    public void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getAgilityPoints() {
        return agilityPoints;
    }

    public void setAgilityPoints(int agilityPoints) {
        this.agilityPoints = agilityPoints;
    }

    public int getIntelligencePoints() {
        return intelligencePoints;
    }

    public void setIntelligencePoints(int intelligencePoints) {
        this.intelligencePoints = intelligencePoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getStaminaPoints() {
        return staminaPoints;
    }

    public void setStaminaPoints(int staminaPoints) {
        this.staminaPoints = staminaPoints;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public RoleEnum getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleEnum roleType) {
        this.roleType = roleType;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    @Override
    public String toString() {
        return "Character{" +
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
                ", roleType=" + getRoleType() +
                '}';
    }
}
