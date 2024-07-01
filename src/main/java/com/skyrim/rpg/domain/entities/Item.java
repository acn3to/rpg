package com.skyrim.rpg.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private String description;
    private int value;
    private List<String> effects;

    public Item(String name, int value, List<String> effects) {
        this.name = name;
        this.value = value;
        this.effects = new ArrayList<>();
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

    public List<String> getEffects() {
        return effects;
    }

    public void setEffects(List<String> effects) {
        this.effects = effects;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", value=" + getValue() +
                ", effects=" + getEffects() +
                '}';
    }
}
