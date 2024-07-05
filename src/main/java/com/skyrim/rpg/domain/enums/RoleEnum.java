package com.skyrim.rpg.domain.enums;

import java.util.List;

public enum RoleEnum {
    DEFAULT_ROLE(
            "Default Role",
            "Generic role for characters",
            70,
            8,
            6,
            8,
            8,
            10,
            7,
            List.of(SkillEnum.BASIC_ATTACK),
            null,
            StatusEnum.NORMAL,
            "Default"
    ),
    WARRIOR(
            "Warrior",
            "A strong and resilient fighter, skilled in melee combat.",
            100,
            12,
            12,
            5,
            5,
            10,
            8,
            List.of(SkillEnum.THUNDEROUS_BLOW),
            null,
            null,
            null
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
            6,
            List.of(SkillEnum.GLACIAL_SPIKE),
            null,
            null,
            null
    ),
    ARCHER(
            "Archer",
            "A ranged combatant with exceptional accuracy and agility.",
            90,
            8,
            8,
            10,
            7,
            8,
            7,
            List.of(SkillEnum.PRECISION_SHOT),
            null,
            null,
            null
    ),
    ASSASSIN(
            "Assassin",
            "A stealthy killer who excels in dealing poison damage.",
            85,
            10,
            7,
            8,
            6,
            7,
            10,
            List.of(SkillEnum.VENOMOUS_STRIKE),
            null,
            null,
            null
    ),
    ENEMY_DRAGON(
            "Dragon",
            "Fire-breathing dragon",
            200,
            20,
            15,
            10,
            15,
            20,
            15,
            List.of(),
            500,
            StatusEnum.BOSS,
            "Dragon"
    ),
    ENEMY_GOBLIN(
            "Goblin",
            "Small, sneaky creature",
            50,
            8,
            5,
            6,
            4,
            0,
            8,
            List.of(),
            25,
            StatusEnum.NORMAL,
            "Goblin"
    ),
    ENEMY_SKELETON(
            "Skeleton",
            "Undead warrior",
            30,
            10,
            3,
            5,
            2,
            0,
            5,
            List.of(),
            20,
            StatusEnum.NORMAL,
            "Skeleton"
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
    private final List<SkillEnum> defaultSkills;
    private final Integer xpReward;
    private final StatusEnum status;
    private final String type;

    RoleEnum(String roleName, String description, int healthPoints, int strengthPoints, int defensePoints, int agilityPoints,
             int intelligencePoints, int manaPoints, int staminaPoints, List<SkillEnum> defaultSkills, Integer xpReward, StatusEnum status, String type) {
        this.roleName = roleName;
        this.description = description;
        this.healthPoints = healthPoints;
        this.strengthPoints = strengthPoints;
        this.defensePoints = defensePoints;
        this.agilityPoints = agilityPoints;
        this.intelligencePoints = intelligencePoints;
        this.manaPoints = manaPoints;
        this.staminaPoints = staminaPoints;
        this.defaultSkills = defaultSkills;
        this.xpReward = xpReward;
        this.status = status;
        this.type = type;
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

    public List<SkillEnum> getDefaultSkills() {
        return defaultSkills;
    }

    public Integer getXpReward() {
        return xpReward;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RoleEnum{" +
                "roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", healthPoints=" + healthPoints +
                ", strengthPoints=" + strengthPoints +
                ", defensePoints=" + defensePoints +
                ", agilityPoints=" + agilityPoints +
                ", intelligencePoints=" + intelligencePoints +
                ", manaPoints=" + manaPoints +
                ", staminaPoints=" + staminaPoints +
                ", defaultSkills=" + (defaultSkills != null ? defaultSkills : "None") +
                ", xpReward=" + (xpReward != null ? xpReward : "N/A") +
                ", status=" + (status != null ? status : "N/A") +
                ", type='" + type + '\'' +
                '}';
    }
}
