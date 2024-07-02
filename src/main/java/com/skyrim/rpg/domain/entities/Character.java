package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EffectEnum;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.ArrayList;
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
    private RoleEnum role;

    public Character(String id, String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.level = level;
        this.xpPoints = xpPoints;
        this.items = items != null ? items : new ArrayList<>();
        this.skills = skills != null ? skills : new ArrayList<>();
        this.role = role;
        createDefault();
    }

    protected void createDefault() {
        healthPoints = role.getHealthPoints();
        strengthPoints = role.getStrengthPoints();
        defensePoints = role.getDefensePoints();
        agilityPoints = role.getAgilityPoints();
        intelligencePoints = role.getIntelligencePoints();
        manaPoints = role.getManaPoints();
        staminaPoints = role.getStaminaPoints();
        addDefaultSkills(role);
    }

    private void addDefaultSkills(RoleEnum roleEnum) {
        for (SkillEnum skillEnum : roleEnum.getDefaultSkills()) {
            skills.add(createSkill(skillEnum));
        }
    }

    private Skill createSkill(SkillEnum skillEnum) {
        return new Skill(skillEnum.getId(), skillEnum.getName(), skillEnum.getType(), skillEnum.getDescription(), skillEnum.getBaseDamage());
    }

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public void addAttributesFromItems() {
        for (Item item : items) {
            EffectEnum effect = item.getEffect();
            switch (effect.getEffect()) {
                case "manaPoints" -> manaPoints += effect.getValue();
                case "healthPoints" -> healthPoints += effect.getValue();
                case "agilityPoints" -> agilityPoints += effect.getValue();
                case "defensePoints" -> defensePoints += effect.getValue();
                case "staminaPoints" -> staminaPoints += effect.getValue();
                case "intelligencePoints" -> intelligencePoints += effect.getValue();
                default -> { }
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
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
                ", items=" + getItems() +
                ", skills=" + getSkills() +
                ", role=" + getRole() +
                '}';
    }
}
