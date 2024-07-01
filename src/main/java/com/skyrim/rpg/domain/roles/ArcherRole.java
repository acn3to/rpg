package com.skyrim.rpg.domain.roles;

import com.skyrim.rpg.domain.entities.Role;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.ArrayList;
import java.util.List;

public class ArcherRole extends Role {

    public ArcherRole() {
        super(
                RoleEnum.ARCHER.getRoleName(),
                RoleEnum.ARCHER.getDescription(),
                RoleEnum.ARCHER.getSkills(),
                RoleEnum.ARCHER.getBaseHealth(),
                RoleEnum.ARCHER.getBaseMana(),
                RoleEnum.ARCHER.getBaseAttack(),
                RoleEnum.ARCHER.getBaseDefense()
                );
    }

    @Override
    public Skill useSkill(Skill skill) {
        return skill;
    }

    private static List<Skill> getDefaultSkills() {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(
                SkillEnum.PRECISION_SHOT.getName(),
                SkillEnum.PRECISION_SHOT.getDescription(),
                SkillEnum.PRECISION_SHOT.getManaCost(),
                SkillEnum.PRECISION_SHOT.getPower()
                ));
        return skills;
    }
}
