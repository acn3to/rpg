package com.skyrim.rpg.domain.roles;

import com.skyrim.rpg.domain.entities.Role;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.ArrayList;
import java.util.List;

public class WarriorRole extends Role {
    private int strength;

    public WarriorRole(String name, String description, List<Skill> skills, int baseHealth, int baseMana, int baseAttack, int baseDefense, int strength) {
        super(
                RoleEnum.WARRIOR.getRoleId(),
                RoleEnum.WARRIOR.getRoleName(),
                RoleEnum.WARRIOR.getDescription(),
                RoleEnum.WARRIOR.getSkills(),
                RoleEnum.WARRIOR.getBaseHealth(),
                RoleEnum.WARRIOR.getBaseMana(),
                RoleEnum.WARRIOR.getBaseAttack(),
                RoleEnum.WARRIOR.getBaseDefense()
        );
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public Skill useSkill(Skill skill) {
        return skill;
    }

    private static List<Skill> getDefaultSkills() {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(
                SkillEnum.THUNDEROUS_BLOW.getId(),
                SkillEnum.THUNDEROUS_BLOW.getName(),
                SkillEnum.THUNDEROUS_BLOW.getDescription(),
                SkillEnum.THUNDEROUS_BLOW.getManaCost(),
                SkillEnum.THUNDEROUS_BLOW.getPower()
        ));
        return skills;
    }
}
