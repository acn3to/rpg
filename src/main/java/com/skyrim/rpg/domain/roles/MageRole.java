package com.skyrim.rpg.domain.roles;

import com.skyrim.rpg.domain.entities.Role;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.ArrayList;
import java.util.List;

public class MageRole extends Role {
    private int intelligence;

    public MageRole(String name, String description, List<Skill> skills, int baseHealth, int baseMana, int baseAttack, int baseDefense, int intelligence) {
        super(
                RoleEnum.MAGE.getRoleId(),
                RoleEnum.MAGE.getRoleName(),
                RoleEnum.MAGE.getDescription(),
                RoleEnum.MAGE.getSkills(),
                RoleEnum.MAGE.getBaseHealth(),
                RoleEnum.MAGE.getBaseMana(),
                RoleEnum.MAGE.getBaseAttack(),
                RoleEnum.MAGE.getBaseDefense()
        );
        this.intelligence = intelligence;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public Skill useSkill(Skill skill) {
        return skill;
    }

    private static List<Skill> getDefaultSkills() {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(
                SkillEnum.GLACIAL_SPIKE.getId(),
                SkillEnum.GLACIAL_SPIKE.getName(),
                SkillEnum.GLACIAL_SPIKE.getDescription(),
                SkillEnum.GLACIAL_SPIKE.getManaCost(),
                SkillEnum.GLACIAL_SPIKE.getPower()
        ));
        return skills;
    }
}
