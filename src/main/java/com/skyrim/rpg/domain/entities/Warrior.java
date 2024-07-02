package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EffectEnum;
import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

public class Warrior extends Character {
    private int ragePoints;

    public Warrior(String id, String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, int ragePoints) {
        super(id, name, description, level, xpPoints, items, skills, role);
        this.ragePoints = ragePoints;
    }

    public int getRagePoints() {
        return ragePoints;
    }

    public void setRagePoints(int ragePoints) {
        this.ragePoints = ragePoints;
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            EffectEnum effect = item.getEffect();
            switch (effect.getEffect()) {
                case "ragePoints" -> setRagePoints(getRagePoints() + (int) effect.getValue());
                default -> { }
            }
        }
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "ragePoints=" + getRagePoints() +
                '}';
    }
}
