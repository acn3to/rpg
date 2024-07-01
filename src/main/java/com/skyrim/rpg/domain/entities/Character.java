package com.skyrim.rpg.domain.entities;

public class Character {
    private int id;
    private String name;
    private Role role;
    private int level;
    private int xpPoints;
    private int healthPoints;
    private int manaPoints;


    public Character(int id, String name, Role role, int level, int xpPoints, int healthPoints, int manaPoints) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.level = level;
        this.xpPoints = xpPoints;
        this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
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

    protected int getManaPoints() {
        return manaPoints;
    }

    protected void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    int retrieveLevel() {
        return this.getLevel();
    }

    public int getBaseAttack() {
        return role.getBaseAttack();
    }

    public int getBaseDefense() {
        return role.getBaseDefense();
    }

    public void takeDamage(int damage) {
        int newHealth = getHealthPoints() - damage;
        setHealthPoints(Math.max(newHealth, 0));
    }

    public void heal(int amount) {
        int newHealth = getHealthPoints() + amount;
        setHealthPoints(Math.min(newHealth, getHealthPoints()));
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", role=" + getRole() +
                ", level=" + getLevel() +
                ", xpPoints=" + getXpPoints() +
                ", healthPoints=" + getHealthPoints() +
                ", manaPoints=" + getManaPoints() +
                '}';
    }
}
