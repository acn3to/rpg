package com.skyrim.rpg.domain.enums;

public enum SkillEnum {
    PRECISION_SHOT(
            "Precision Shot",
            "A focused, high-precision arrow shot that targets a specific weak point, dealing critical damage to a single enemy.",
            15,
            20
    ),
    THUNDEROUS_BLOW(
            "Thunderous Blow",
            "Unleashes a powerful overhead strike, causing significant damage and possibly staggering the enemy.",
            20,
            25
    ),
    GLACIAL_SPIKE(
            "Glacial Spike",
            "Summons a spike of ice from the ground to impale and freeze enemies, dealing cold damage and immobilizing them briefly.",
            25,
            30
    ),
    VENOMOUS_STRIKE(
            "Venomous Strike",
            "Coats the assassin's weapon with a deadly poison that causes ongoing damage to the target over time, weakening them with each strike.",
            18,
            15
    );

    private final String name;
    private final String description;
    private final int manaCost;
    private final int power;

    SkillEnum(String name, String description, int manaCost, int power) {
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getPower() {
        return power;
    }
}
