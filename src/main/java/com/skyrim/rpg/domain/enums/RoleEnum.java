package com.skyrim.rpg.domain.enums;

public enum RoleEnum {
    WARRIOR(
            "Warrior",
            "A strong and resilient fighter, skilled in melee combat.",
            100,
            12,
            10,
            5,
            5,
            10,
            8
    ),
    MAGE(
            "Mage",
            "A master of the arcane arts, capable of powerful spells.",
            80,
            5,
            6,
            4,
            15,
            15,
            6
    ),
    ARCHER(
            "Archer",
            "A ranged combatant with exceptional accuracy and agility.",
            90,
            8,
            8,
            12,
            7,
            8,
            7
    ),
    ASSASSIN(
            "Assassin",
            "A stealthy killer who excels in dealing poison damage.",
            85,
            10,
            7,
            10,
            6,
            7,
            10
    );

    private final String roleName;
    private final String description;
    private final int healthPoints;
    private final int strengthPoints;
    private final int defensePoints;
    private final int agilityPoints;
    private final int intelligencePoints;
    private final int manaPoints;
    private final int staminaPoints;

    RoleEnum(String roleName, String description, int healthPoints, int strengthPoints, int defensePoints, int agilityPoints, int intelligencePoints, int manaPoints, int staminaPoints) {
        this.roleName = roleName;
        this.description = description;
        this.healthPoints = healthPoints;
        this.strengthPoints = strengthPoints;
        this.defensePoints = defensePoints;
        this.agilityPoints = agilityPoints;
        this.intelligencePoints = intelligencePoints;
        this.manaPoints = manaPoints;
        this.staminaPoints = staminaPoints;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getStrengthPoints() {
        return strengthPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getAgilityPoints() {
        return agilityPoints;
    }

    public int getIntelligencePoints() {
        return intelligencePoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public int getStaminaPoints() {
        return staminaPoints;
    }

    @Override
    public String toString() {
        return "RoleEnum{" +
                "roleName='" + getRoleName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", healthPoints=" + getHealthPoints() +
                ", strengthPoints=" + getStrengthPoints() +
                ", defensePoints=" + getDefensePoints() +
                ", agilityPoints=" + getAgilityPoints() +
                ", intelligencePoints=" + getIntelligencePoints() +
                ", manaPoints=" + getManaPoints() +
                ", staminaPoints=" + getStaminaPoints() +
                '}';
    }
}
