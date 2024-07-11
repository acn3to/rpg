package com.skyrim.rpg.domain.enums;

import com.skyrim.rpg.domain.entities.Skill;

import java.util.ArrayList;
import java.util.List;

public enum RoleEnum {
    WARRIOR(
            "Warrior",
            "A strong and brave fighter, skilled in melee combat and heavy armor. Known for their valor in battles across Whiterun and Falkreath.",
            100, 15, 10, 5, 5, 5, 20
    ),
    ARCHER(
            "Archer",
            "A nimble and accurate marksman, expert in ranged attacks with bows. Hailing from the forests of Riften, they are renowned for their precision.",
            80, 10, 5, 15, 5, 5, 20
    ),
    MAGE(
            "Mage",
            "A master of arcane arts, capable of casting powerful spells. Originating from the College of Winterhold, they study ancient magic and lore.",
            60, 5, 5, 5, 20, 20, 10
    ),
    ASSASSIN(
            "Assassin",
            "A stealthy and deadly killer, skilled in deception and quick strikes. Operating in the shadows of Windhelm and Solitude, they strike fear into their targets.",
            70, 10, 5, 20, 5, 5, 20
    );

    private final String name;
    private final String description;
    private final int health;
    private final int strength;
    private final int defense;
    private final int agility;
    private final int intelligence;
    private final int mana;
    private final int stamina;

    RoleEnum(String name, String description, int health, int strength, int defense, int agility, int intelligence, int mana, int stamina) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.intelligence = intelligence;
        this.mana = mana;
        this.stamina = stamina;
    }

    public List<Skill> getDefaultSkills() {
        List<Skill> defaultSkills = new ArrayList<>();
        switch (this) {
            case WARRIOR:
                defaultSkills.add(new Skill("1", "Slash", "Attack", "A powerful slash with a sword.", 15));
                break;
            case ARCHER:
                defaultSkills.add(new Skill("2", "Arrow Shot", "Attack", "A precise shot with a bow.", 10));
                break;
            case MAGE:
                defaultSkills.add(new Skill("3", "Fireball", "Magic", "A fiery projectile.", 20));
                break;
            case ASSASSIN:
                defaultSkills.add(new Skill("4", "Back-stab", "Attack", "A sneaky attack from behind.", 25));
                break;
        }
        return defaultSkills;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getMana() {
        return mana;
    }

    public int getStamina() {
        return stamina;
    }
}
