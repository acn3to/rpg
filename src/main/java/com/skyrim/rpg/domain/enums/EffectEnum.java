package com.skyrim.rpg.domain.enums;

public enum EffectEnum {
    RAGE_BOOST(
            "Rage Boost",
            "Increases rage points by 10",
            "ragePoints",
            10
    ),
    MANA_REGEN(
            "Mana Regeneration",
            "Regenerates mana by 5 points per round",
            "manaPoints",
            5
    ),
    CRITICAL_HIT_BOOST(
            "Critical Hit Boost",
            "Increases critical hit chance by 0.2",
            "criticalHitChance",
            0.2
    ),
    HEAL(
            "Heal",
            "Heals 50 health points at the end of each round",
            "healthPoints",
            50
    ),
    AGILITY_BOOST(
            "Agility Boost",
            "Increases agility points by 3",
            "agilityPoints",
            3
    ),
    DEFENSE_BOOST(
            "Defense Boost",
            "Increases defense points by 5",
            "defensePoints",
            5
    ),
    INTELLECT_BOOST(
            "Intellect Boost",
            "Increases intellect points by 4",
            "intellectPoints",
            4
    ),
    STAMINA_BOOST(
            "Stamina Boost",
            "Increases stamina points by 8",
            "staminaPoints",
            8
    );

    private final String name;
    private final String description;
    private final String effect;
    private final double value;

    EffectEnum(String name, String description, String effect, double value) {
        this.name = name;
        this.description = description;
        this.effect = effect;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEffect() {
        return effect;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "EffectEnum{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", effect='" + getEffect() + '\'' +
                ", value=" + getValue() +
                '}';
    }
}
