package com.skyrim.rpg.domain.enums;

public enum SkillEnum {
    PRECISION_SHOT(
            1,
            "Precision Shot",
            "Normal",
            "A focused, high-precision arrow shot that targets a specific weak point, dealing critical damage to a single enemy.",
            15
    ),
    THUNDEROUS_BLOW(
            2,
            "Thunderous Blow",
            "Normal",
            "Unleashes a powerful overhead strike, causing significant damage and possibly staggering the enemy.",
            20
    ),
    GLACIAL_SPIKE(
            3,
            "Glacial Spike",
            "Ice",
            "Summons a spike of ice from the ground to impale and freeze enemies, dealing cold damage and immobilizing them briefly.",
            25
    ),
    VENOMOUS_STRIKE(
            4,
            "Venomous Strike",
            "Poison",
            "Coats the assassin's weapon with a deadly poison that causes ongoing damage to the target over time, weakening them with each strike.",
            18
    );

    private final int id;
    private final String name;
    private final String type;
    private final String description;
    private final int baseDamage;

    SkillEnum(int id, String name, String type, String description, int baseDamage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.baseDamage = baseDamage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return "SkillEnum{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", baseDamage=" + getBaseDamage() +
                '}';
    }
}
