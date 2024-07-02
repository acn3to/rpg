package com.skyrim.rpg.domain.entities;

public class Skill {
    private int id;
    private String name;
    private String type;
    private String description;
    public int baseDamage;

    public Skill(int id, String name, String type, String description, int baseDamage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.baseDamage = baseDamage;
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

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", baseDamage=" + getBaseDamage() +
                '}';
    }
}

