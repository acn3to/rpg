package com.skyrim.rpg.domain.entities;

public class Skill {
    private int id;
    private String name;
    private String type;
    private String description;
    private int manaCost;
    private int power;

    public Skill(int id, String name, String type, String description, int manaCost, int power) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.manaCost = manaCost;
        this.power = power;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", manaCost=" + getManaCost() +
                ", power=" + getPower() +
                '}';
    }
}

