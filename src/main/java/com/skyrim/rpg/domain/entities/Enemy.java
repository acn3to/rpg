package com.skyrim.rpg.domain.entities;

import java.util.List;

public class Enemy extends Character {
    private String type;
    private int xpReward;

    public Enemy(String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, String type, int xpReward) {
        super(name, description, level, xpPoints, items, skills, type);
        this.type = type;
        this.xpReward = xpReward;
    }

    @Override
    public int calculateAttackDamage() {
        return getStrengthPoints() * 2;
    }

    @Override
    public int calculateSkillDamage(Skill skill) {
        return getStrengthPoints() * 3;
    }

    @Override
    public double calculateCriticalChance() {
        return 1.0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getXpReward() {
        return xpReward;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "type='" + getType() + '\'' +
                ", xpReward=" + getXpReward() +
                '}';
    }
}
