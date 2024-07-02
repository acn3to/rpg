package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EffectEnum;

public class Item {
    private int id;
    private String name;
    private String description;
    private int value;
    private EffectEnum effect;

    public Item(int id, String name, String description, int value, EffectEnum effect) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public EffectEnum getEffect() {
        return effect;
    }

    public void setEffect(EffectEnum effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", value=" + getValue() +
                ", effect=" + getEffect() +
                '}';
    }
}
