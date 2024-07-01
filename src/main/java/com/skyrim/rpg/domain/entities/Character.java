package com.skyrim.rpg.domain.entities;

public class Character {
    private String name;
    private Role role;
    private int level;
    private int healthPoints;
    private int manaPoints;
    private int strength;
    private int intelligence;
    private int dexterity;
    private int agility;

    public Character(String name, Role role, int level, int healthPoints, int manaPoints, int strength, int intelligence, int dexterity, int agility) {
        this.name = name;
        this.role = role;
        this.level = level;
        this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.agility = agility;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Role getRole() {
        return role;
    }

    protected void setRole(Role role) {
        this.role = role;
    }

    protected int getLevel() {
        return level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    protected int getHealthPoints() {
        return healthPoints;
    }

    protected void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    protected int getManaPoints() {
        return manaPoints;
    }

    protected void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    protected int getStrength() {
        return strength;
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected int getIntelligence() {
        return intelligence;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    protected int getDexterity() {
        return dexterity;
    }

    protected void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    protected int getAgility() {
        return agility;
    }

    protected void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", level=" + level +
                ", healthPoints=" + healthPoints +
                ", manaPoints=" + manaPoints +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                '}';
    }
}
