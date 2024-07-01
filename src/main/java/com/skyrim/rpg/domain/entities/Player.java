package com.skyrim.rpg.domain.entities;

public class Player extends Character {
    private int gold;

    public Player(int id, String name, Role role, int level, int xpPoints, int healthPoints, int manaPoints, int gold) {
        super(id, name, role, level, xpPoints, healthPoints, manaPoints);
        this.gold = 100;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", role=" + getRole() +
                ", level=" + getLevel() +
                ", xpPoints=" + getXpPoints() +
                ", healthPoints=" + getHealthPoints() +
                ", manaPoints=" + getManaPoints() +
                ", gold=" + getGold() +
                '}';
    }
}
