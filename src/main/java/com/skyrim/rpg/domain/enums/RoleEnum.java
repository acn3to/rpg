package com.skyrim.rpg.domain.enums;

import com.skyrim.rpg.domain.entities.Skill;

import java.util.List;

public enum RoleEnum {
    ARCHER(
            1,
            "Archer",
            "In the sprawling forests of Falkreath and the mist-shrouded marshes of Morthal, Archers in Skyrim are revered for their mastery of ranged combat. With bows crafted from the finest materials found in Solitude's workshops, they strike with lethal precision from the shadows. Skilled in the art of stealth and evasion, these hunters roam Skyrim's wilds.",
            List.of(new Skill(
                    SkillEnum.PRECISION_SHOT.getId(),
                    SkillEnum.PRECISION_SHOT.getName(),
                    SkillEnum.PRECISION_SHOT.getDescription(),
                    SkillEnum.PRECISION_SHOT.getManaCost(),
                    SkillEnum.PRECISION_SHOT.getPower()
            )),
            50,
            25,
            13,
            9
    ),

    WARRIOR(
            2,
            "Warrior",
            "On the battlefields of Whiterun's plains and amidst the ancient ruins of Markarth, Skyrim's Warriors are celebrated for their prowess in close combat. Clad in armor forged by Riften's finest smiths, they fearlessly charge into the fray, wielding swords honed in Solitude's fires to defend Skyrim's honor and safeguard its people.",
            List.of(new Skill(
                    SkillEnum.THUNDEROUS_BLOW.getId(),
                    SkillEnum.THUNDEROUS_BLOW.getName(),
                    SkillEnum.THUNDEROUS_BLOW.getDescription(),
                    SkillEnum.THUNDEROUS_BLOW.getManaCost(),
                    SkillEnum.THUNDEROUS_BLOW.getPower()
            )),
            80,
            10,
            20,
            15
    ),

    MAGE(
            3,
            "Mage",
            "Within the ancient halls of Winterhold's College and the mystical libraries of its towers, Skyrim's Mages harness the arcane arts with unparalleled expertise. Conjuring storms over Solitude's seas and unraveling mysteries in Whiterun's arcane sanctums, they delve into the depths of Skyrim's magic, seeking to unlock its secrets and shape its future.",
            List.of(new Skill(
                    SkillEnum.GLACIAL_SPIKE.getId(),
                    SkillEnum.GLACIAL_SPIKE.getName(),
                    SkillEnum.GLACIAL_SPIKE.getDescription(),
                    SkillEnum.GLACIAL_SPIKE.getManaCost(),
                    SkillEnum.GLACIAL_SPIKE.getPower()
            )),
            60,
            50,
            18,
            7
    ),

    ASSASSIN(
            4,
            "Assassin",
            "Within the shadowy sanctuaries of Riften's Thieves Guild and the hidden lairs of Skyrim's wilderness, Assassins of the Dark Brotherhood operate unseen and deadly. Trained in the arts of stealth and assassination from Windhelm to Falkreath, they strike fear into their targets' hearts, fulfilling contracts under the guidance of the Night Mother's whispers and the dark auspices of Sithis.",
            List.of(new Skill(
                    SkillEnum.PRECISION_SHOT.getId(),
                    SkillEnum.VENOMOUS_STRIKE.getName(),
                    SkillEnum.VENOMOUS_STRIKE.getDescription(),
                    SkillEnum.VENOMOUS_STRIKE.getManaCost(),
                    SkillEnum.VENOMOUS_STRIKE.getPower()
            )),
            40,
            30,
            15,
            10
    );

    private final int roleId;
    private final String roleName;
    private final String description;
    private final List<Skill> skills;
    private final int baseHealth;
    private final int baseMana;
    private final int baseAttack;
    private final int baseDefense;

    RoleEnum(int roleId, String roleName, String description, List<Skill> skills, int baseHealth, int baseMana, int baseAttack, int baseDefense) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
        this.skills = skills;
        this.baseHealth = baseHealth;
        this.baseMana = baseMana;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getBaseMana() {
        return baseMana;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }
}
