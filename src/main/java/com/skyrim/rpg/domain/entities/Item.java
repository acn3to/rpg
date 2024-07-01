package com.skyrim.rpg.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int id;
    private String name;
    private String description;
    private int value;
    private List<String> effects;

    public Item(int id, String name, String description, int value, List<String> effects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.effects = effects;
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

    public List<String> getEffects() {
        return effects;
    }

    public void setEffects(List<String> effects) {
        this.effects = effects;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", value=" + getValue() +
                ", effects=" + getEffects() +
                '}';
    }
}
