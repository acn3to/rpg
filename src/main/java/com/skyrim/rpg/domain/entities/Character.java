package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EffectEnum;

import java.util.List;

public class Character {
    private String id;
    private String name;
    private String description;
    private int level;
    private int xpPoints;
    private int healthPoints;
    private int strengthPoints;
    private int defensePoints;
    private int agilityPoints;
    private int intelligencePoints;
    private int manaPoints;
    private int staminaPoints;
    private List<Item> items;
    private List<Skill> skills;

    public Character(String id, String name, String description, int level, int xpPoints, int healthPoints, int strengthPoints, int defensePoints, int agilityPoints, int intelligencePoints, int manaPoints, int staminaPoints, List<Item> items, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.level = level;
        this.xpPoints = xpPoints;
        this.healthPoints = healthPoints;
        this.strengthPoints = strengthPoints;
        this.defensePoints = defensePoints;
        this.agilityPoints = agilityPoints;
        this.intelligencePoints = intelligencePoints;
        this.manaPoints = manaPoints;
        this.staminaPoints = staminaPoints;
        this.items = items;
        this.skills = skills;
        addAttributesFromItems();
    }

    protected void addAttributesFromItems() {
        for (Item item : items) {
            EffectEnum effect = item.getEffect();
            switch (effect) {
                case AGILITY_BOOST:
                    agilityPoints += effect.getValue();
                    break;
                case DEFENSE_BOOST:
                    defensePoints += effect.getValue();
                    break;
                case INTELLECT_BOOST:
                    intelligencePoints += effect.getValue();
                    break;
                case STAMINA_BOOST:
                    staminaPoints += effect.getValue();
                    break;
                case MANA_REGEN:
                    manaPoints += effect.getValue();
                    break;
                default:
                    break;
            }
        }
    }

    protected String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected int getLevel() {
        return level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    protected int getXpPoints() {
        return xpPoints;
    }

    protected void setXpPoints(int xpPoints) {
        this.xpPoints = xpPoints;
    }

    protected int getHealthPoints() {
        return healthPoints;
    }

    protected void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    protected int getStrengthPoints() {
        return strengthPoints;
    }

    protected void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }

    protected int getDefensePoints() {
        return defensePoints;
    }

    protected void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    protected int getAgilityPoints() {
        return agilityPoints;
    }

    protected void setAgilityPoints(int agilityPoints) {
        this.agilityPoints = agilityPoints;
    }

    protected int getIntelligencePoints() {
        return intelligencePoints;
    }

    protected void setIntelligencePoints(int intelligencePoints) {
        this.intelligencePoints = intelligencePoints;
    }

    protected int getManaPoints() {
        return manaPoints;
    }

    protected void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    protected int getStaminaPoints() {
        return staminaPoints;
    }

    protected void setStaminaPoints(int staminaPoints) {
        this.staminaPoints = staminaPoints;
    }

    protected List<Item> getItems() {
        return items;
    }

    protected void setItems(List<Item> items) {
        this.items = items;
    }

    protected List<Skill> getSkills() {
        return skills;
    }

    protected void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
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
                '}';
    }
}
