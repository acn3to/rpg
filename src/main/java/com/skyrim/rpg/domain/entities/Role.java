package com.skyrim.rpg.domain.entities;

import java.util.List;

public abstract class Role {
    private int id;
    private String name;
    private String description;
    private List<Skill> skills;
    private int baseHealth;
    private int baseMana;
    private int baseAttack;
    private int baseDefense;

    public Role(int id, String name, String description, List<Skill> skills, int baseHealth, int baseMana, int baseAttack, int baseDefense) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.skills = skills;
        this.baseHealth = baseHealth;
        this.baseMana = baseMana;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected List<Skill> getSkills() {
        return skills;
    }

    protected void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    protected int getBaseHealth() {
        return baseHealth;
    }

    protected void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    protected int getBaseMana() {
        return baseMana;
    }

    protected void setBaseMana(int baseMana) {
        this.baseMana = baseMana;
    }

    protected int getBaseAttack() {
        return baseAttack;
    }

    protected void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    protected int getBaseDefense() {
        return baseDefense;
    }

    protected void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public abstract Skill useSkill(Skill skill);

    @Override
    public String toString() {
        return "Role{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", skills=" + getSkills() +
                ", baseHealth=" + getBaseHealth() +
                ", baseMana=" + getBaseMana() +
                ", baseAttack=" + getBaseAttack() +
                ", baseDefense=" + getBaseDefense() +
                '}';
    }
}
