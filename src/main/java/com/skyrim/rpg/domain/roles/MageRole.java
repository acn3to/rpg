package com.skyrim.rpg.domain.roles;

import com.skyrim.rpg.domain.entities.Role;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.ArrayList;
import java.util.List;

public class MageRole extends Role {

    public MageRole() {
        super(
                RoleEnum.MAGE.getRoleName(),
                RoleEnum.MAGE.getDescription(),
                RoleEnum.MAGE.getSkills(),
                RoleEnum.MAGE.getBaseHealth(),
                RoleEnum.MAGE.getBaseMana(),
                RoleEnum.MAGE.getBaseAttack(),
                RoleEnum.MAGE.getBaseDefense()
        );
    }

    @Override
    public Skill useSkill(Skill skill) {
        return skill;
    }

    private static List<Skill> getDefaultSkills() {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(
                SkillEnum.GLACIAL_SPIKE.getName(),
                SkillEnum.GLACIAL_SPIKE.getDescription(),
                SkillEnum.GLACIAL_SPIKE.getManaCost(),
                SkillEnum.GLACIAL_SPIKE.getPower()
        ));
        return skills;
    }
}
