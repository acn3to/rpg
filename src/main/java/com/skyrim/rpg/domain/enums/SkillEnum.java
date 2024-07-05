package com.skyrim.rpg.domain.enums;

public enum SkillEnum {
    PRECISION_SHOT(
            "1",
            "Precision Shot",
            "Normal",
            "A focused, high-precision arrow shot that targets a specific weak point, dealing critical damage to a single enemy.",
            15
    ),
    THUNDEROUS_BLOW(
            "2",
            "Thunderous Blow",
            "Normal",
            "Unleashes a powerful overhead strike, causing significant damage and possibly staggering the enemy.",
            20
    ),
    GLACIAL_SPIKE(
            "3",
            "Glacial Spike",
            "Ice",
            "Summons a spike of ice from the ground to impale and freeze enemies, dealing cold damage and immobilizing them briefly.",
            25
    ),
    VENOMOUS_STRIKE(
            "4",
            "Venomous Strike",
            "Poison",
            "Coats the assassin's weapon with a deadly poison that causes ongoing damage to the target over time, weakening them with each strike.",
            18
    ),
    HEAL(
            "5",
            "Heal",
            "Healing",
            "Channels healing magic to restore a significant amount of health to the caster or an ally.",
            -1
    ),
    BASIC_ATTACK(
            "6",
            "Basic Attack",
            "Normal",
            "A standard melee attack or simple ranged shot, dealing moderate damage to a single enemy.",
            10
    );

    private final String id;
    private final String name;
    private final String type;
    private final String description;
    private final int baseDamage;

    SkillEnum(String id, String name, String type, String description, int baseDamage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.baseDamage = baseDamage;
    }

    public String getId() {
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
