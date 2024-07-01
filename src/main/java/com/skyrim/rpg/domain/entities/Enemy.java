package com.skyrim.rpg.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Character {
    private String type;
    private int xpReward;
    private int attackPoints;
    private int defensePoints;
    private List<Item> loot;

    public Enemy(Long id, String name, Role role, int level, int xpPoints, int healthPoints, int manaPoints, String type, int xpReward, int attackDamage, int defense, List<Item> loot) {
        super(id, name, role, level, xpPoints, healthPoints, manaPoints);
        this.type = type;
        this.xpReward = xpReward;
        this.attackPoints = attackDamage;
        this.defensePoints = defense;
        this.loot = new ArrayList<>();
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

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public List<Item> getLoot() {
        return loot;
    }

    public void setLoot(List<Item> loot) {
        this.loot = loot;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "id=" + getId() +
                ", type='" + getType() + '\'' +
                ", xpReward=" + getXpReward() +
                ", attackPoints=" + getAttackPoints() +
                ", defensePoints=" + getDefensePoints() +
                ", loot=" + getLoot() +
                '}';
    }
}
