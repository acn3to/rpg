package com.skyrim.rpg.domain.entities;

public class Character {
    private Long id;
    private String name;
    private Role role;
    private int level;
    private int xpPoints;
    private int healthPoints;
    private int manaPoints;


    public Character(Long id, String name, Role role, int level, int xpPoints, int healthPoints, int manaPoints) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.level = level;
        this.xpPoints = xpPoints;
        this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
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

    protected Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public int getXpPoints() {
        return xpPoints;
    }

    public void setXpPoints(int xpPoints) {
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
