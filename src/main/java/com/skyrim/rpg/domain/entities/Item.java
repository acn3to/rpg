package com.skyrim.rpg.domain.entities;

import java.util.UUID;

public class Item {
    private String id;
    private String name;
    private String description;
    private int value;
    private String effect;
    private String effectDescription;
    private int effectBuff;

    public Item(String name, String description, int value, String effect, String effectDescription, int effectBuff) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.value = value;
        this.effect = effect;
        this.effectDescription = effectDescription;
        this.effectBuff = effectBuff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getEffectDescription() {
        return effectDescription;
    }

    public void setEffectDescription(String effectDescription) {
        this.effectDescription = effectDescription;
    }

    public int getEffectBuff() {
        return effectBuff;
    }

    public void setEffectBuff(int effectBuff) {
        this.effectBuff = effectBuff;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", value=" + getValue() +
                ", effect='" + getEffect() + '\'' +
                ", effectDescription='" + getEffectDescription() + '\'' +
                ", effectBuff=" + getEffectBuff() +
                '}';
    }
}
