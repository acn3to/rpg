package com.skyrim.rpg.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Character {
    private final String id;
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
    private String roleType;

    public Character(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, String roleType) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.level = level;
        this.xpPoints = xpPoints;
        this.items = items != null ? items : new ArrayList<>();
        this.skills = skills != null ? skills : new ArrayList<>();
        this.roleType = roleType;
        initializeRoleAttributes(roleType);
        addDefaultSkills(roleType);
        addAttributesFromItems();
    }

    protected void initializeRoleAttributes(String roleType) {
        switch (roleType) {
            case "Warrior":
                this.healthPoints = 100;
                this.strengthPoints = 15;
                this.defensePoints = 10;
                this.agilityPoints = 5;
                this.intelligencePoints = 5;
                this.manaPoints = 5;
                this.staminaPoints = 20;
                break;
            case "Archer":
                this.healthPoints = 80;
                this.strengthPoints = 10;
                this.defensePoints = 5;
                this.agilityPoints = 15;
                this.intelligencePoints = 5;
                this.manaPoints = 5;
                this.staminaPoints = 20;
                break;
            case "Mage":
                this.healthPoints = 60;
                this.strengthPoints = 5;
                this.defensePoints = 5;
                this.agilityPoints = 5;
                this.intelligencePoints = 20;
                this.manaPoints = 20;
                this.staminaPoints = 10;
                break;
            case "Assassin":
                this.healthPoints = 70;
                this.strengthPoints = 10;
                this.defensePoints = 5;
                this.agilityPoints = 20;
                this.intelligencePoints = 5;
                this.manaPoints = 5;
                this.staminaPoints = 20;
                break;
            case "Dragon":
                this.healthPoints = 200;
                this.strengthPoints = 25;
                this.defensePoints = 15;
                this.agilityPoints = 10;
                this.intelligencePoints = 10;
                this.manaPoints = 10;
                this.staminaPoints = 30;
                break;
            case "Goblin":
                this.healthPoints = 50;
                this.strengthPoints = 5;
                this.defensePoints = 5;
                this.agilityPoints = 10;
                this.intelligencePoints = 5;
                this.manaPoints = 5;
                this.staminaPoints = 10;
                break;
            case "Skeleton":
                this.healthPoints = 40;
                this.strengthPoints = 5;
                this.defensePoints = 5;
                this.agilityPoints = 5;
                this.intelligencePoints = 5;
                this.manaPoints = 5;
                this.staminaPoints = 10;
                break;
            default:
                throw new IllegalArgumentException("Unknown role type: " + roleType);
        }
    }

    protected void addDefaultSkills(String roleType) {
        switch (roleType) {
            case "Warrior":
                skills.add(new Skill("1", "Slash", "Attack", "A powerful slash with a sword.", 15));
                break;
            case "Archer":
                skills.add(new Skill("2", "Arrow Shot", "Attack", "A precise shot with a bow.", 10));
                break;
            case "Mage":
                skills.add(new Skill("3", "Fireball", "Magic", "A fiery projectile.", 20));
                break;
            case "Assassin":
                skills.add(new Skill("4", "Back-stab", "Attack", "A sneaky attack from behind.", 25));
                break;
            case "Dragon":
                skills.add(new Skill("5", "Fire Breath", "Magic", "A breath of fire.", 30));
                break;
            case "Goblin":
                skills.add(new Skill("6", "Club Smash", "Attack", "A smash with a club.", 5));
                break;
            case "Skeleton":
                skills.add(new Skill("7", "Bone Rattle", "Attack", "A rattling bone attack.", 5));
                break;
            default:
                throw new IllegalArgumentException("Unknown role type: " + roleType);
        }
    }

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

    protected void addItem(Item item) {
        if (item != null) {
            items.add(item);
            addAttributesFromItems();
        }
    }

    public abstract int calculateAttackDamage();

    public abstract int calculateSkillDamage(Skill skill);

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

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
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
                ", roleType='" + getRoleType() + '\'' +
                '}';
    }
}
