package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

public class Enemy extends Character{
    private String type;
    private int xpReward;

    public Enemy(String id, String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, String type, int xpReward) {
        super(id, name, description, level, xpPoints, items, skills, role);
        this.type = type;
        this.xpReward = xpReward;
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
