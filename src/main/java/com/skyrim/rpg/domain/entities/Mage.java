package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EffectEnum;
import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

public class Mage extends Character {
    private int manaRegenRate;

    public Mage(String id, String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, int manaRegenRate) {
        super(id, name, description, level, xpPoints, items, skills, role);
        this.manaRegenRate = manaRegenRate;
    }

    public int getManaRegenRate() {
        return manaRegenRate;
    }

    public void setManaRegenRate(int manaRegenRate) {
        this.manaRegenRate = manaRegenRate;
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            EffectEnum effect = item.getEffect();
            switch (effect.getEffect()) {
                case "manaRegenRate" -> setManaRegenRate(getManaRegenRate() + (int) effect.getValue());
                //TODO: add other effects
                default -> { }
            }
        }
    }

    @Override
    public String toString() {
        return "Mage{" +
                "manaRegenRate=" + getManaRegenRate() +
                '}';
    }
}
