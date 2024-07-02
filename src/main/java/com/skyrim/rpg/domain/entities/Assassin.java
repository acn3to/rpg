package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EffectEnum;
import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

public class Assassin extends Character {
    private int poisonDamage;

    public Assassin(String id, String name, String description, int level, int xpPoints, List<Item> items, List<Skill> skills, RoleEnum role, int poisonDamage) {
        super(id, name, description, level, xpPoints, items, skills, role);
        this.poisonDamage = poisonDamage;
    }

    public int getPoisonDamage() {
        return poisonDamage;
    }

    public void setPoisonDamage(int poisonDamage) {
        this.poisonDamage = poisonDamage;
    }

    @Override
    public void addAttributesFromItems() {
        super.addAttributesFromItems();

        for (Item item : getItems()) {
            EffectEnum effect = item.getEffect();
            switch (effect.getEffect()) {
                case "poisonDamage" -> setPoisonDamage(getPoisonDamage() + (int) effect.getValue());
                //TODO: Add other effects
                default -> { }
            }
        }
    }

    @Override
    public String toString() {
        return "Assassin{" +
                "poisonDamage=" + getPoisonDamage() +
                '}';
    }
}
