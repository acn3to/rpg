package com.skyrim.rpg.domain.enums;

import com.skyrim.rpg.domain.entities.Skill;

import java.util.Arrays;
import java.util.List;

public enum EnemyEnum {
    DRAGON("Alduin", "A mighty and ancient creature, feared for its strength and fire breath.", 50, 100, 20, 15, 10, 10, 50, 80, "Flying",
            500, Arrays.asList(
            new Skill("1", "Fire Breath", "Attack", "Breathes fire on the enemy.", 30),
            new Skill("2", "Claw Swipe", "Attack", "Swipes with sharp claws.", 25))),
    GOBLIN("Riekling", "A small and cunning creature, known for its trickery and swiftness.", 5, 100, 8, 5, 15, 5, 10, 20, "Normal",
            50, Arrays.asList(
            new Skill("1", "Trickery", "Attack", "Uses trickery to confuse the enemy.", 10),
            new Skill("2", "Swift Strike", "Attack", "Strikes swiftly with a weapon.", 15))),
    SKELETON("Draugr", "An undead warrior, reanimated and relentless in battle.", 10, 100, 12, 8, 5, 5, 0, 30, "Undead",
            100, Arrays.asList(
            new Skill("1", "Bone Bash", "Attack", "Bashes with bony fists.", 20),
            new Skill("2", "Undead Resilience", "Defense", "Uses undead resilience to resist damage.", 0))),
    FROST_TROLL("Frost Troll", "A formidable creature found in cold regions, known for its regeneration.", 20, 100, 18, 12, 8, 8, 20, 60, "Normal",
            200, Arrays.asList(
            new Skill("1", "Regeneration", "Defense", "Regenerates health over time.", 0),
            new Skill("2", "Ice Strike", "Attack", "Strikes with icy claws.", 25))),
    DRAUGR("Deathlord", "Undead warriors of Skyrim's tombs, resistant to cold and immune to poison.", 15, 100, 14, 10, 6, 6, 0, 40, "Undead",
            150, Arrays.asList(
            new Skill("1", "Frost Resistance", "Defense", "Resists cold attacks.", 0),
            new Skill("2", "Poison Immunity", "Defense", "Immune to poison attacks.", 0))),
    GIANT("Giant", "Massive creatures that dwell in Skyrim's wilderness, known for their strength.", 25, 100, 22, 15, 5, 5, 0, 70, "Normal",
            300, Arrays.asList(
            new Skill("1", "Ground Pound", "Attack", "Pounds the ground with immense force.", 35),
            new Skill("2", "Toss", "Attack", "Tosses enemies aside.", 30))),
    ICE_WRAITH("Ice Wraith", "Ghostly beings composed of ice, found in icy caves and glaciers.", 18, 100, 16, 10, 12, 10, 50, 50, "Ghost",
            250, Arrays.asList(
            new Skill("1", "Ice Beam", "Attack", "Fires a beam of ice.", 25),
            new Skill("2", "Chill Touch", "Attack", "Touches with icy cold.", 20)));

    private final String name;
    private final String description;
    private final int level;
    private final int healthPoints;
    private final int strength;
    private final int defense;
    private final int agility;
    private final int intelligence;
    private final int mana;
    private final int stamina;
    private final String type;
    private final int xpRewards;
    private final List<Skill> skills;

    EnemyEnum(String name, String description, int level, int healthPoints, int strength, int defense, int agility,
              int intelligence, int mana, int stamina, String type, int xpRewards, List<Skill> skills) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.intelligence = intelligence;
        this.mana = mana;
        this.stamina = stamina;
        this.type = type;
        this.xpRewards = xpRewards;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public int getHealthPoints() {
        return healthPoints;
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

    public String getType() {
        return type;
    }

    public int getXpRewards() {
        return xpRewards;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
