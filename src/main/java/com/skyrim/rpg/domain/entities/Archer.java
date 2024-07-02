package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EffectEnum;
import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

public class Archer extends Character {
    private double criticalHitChance;

    public Archer(String id, String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, double criticalHitChance) {
        super(id, name, description, level, xpPoints, items, skills, role);
        this.criticalHitChance = criticalHitChance;
    }

    public double getCriticalHitChance() {
        return criticalHitChance;
    }

    public void setCriticalHitChance(double criticalHitChance) {
        this.criticalHitChance = criticalHitChance;
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            EffectEnum effect = item.getEffect();
            switch (effect.getEffect()) {
                case "criticalHitChance" -> setCriticalHitChance(getCriticalHitChance() + effect.getValue());
                default -> { }
            }
        }
    }

    @Override
    public String toString() {
        return "Archer{" +
                "criticalHitChance=" + getCriticalHitChance() +
                '}';
    }
}
