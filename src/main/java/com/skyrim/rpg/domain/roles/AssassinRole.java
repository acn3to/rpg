package com.skyrim.rpg.domain.roles;

import com.skyrim.rpg.domain.entities.Role;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.ArrayList;
import java.util.List;

public class AssassinRole extends Role {

    public AssassinRole() {
        super(
                RoleEnum.ASSASSIN.getRoleId(),
                RoleEnum.ASSASSIN.getRoleName(),
                RoleEnum.ASSASSIN.getDescription(),
                RoleEnum.ASSASSIN.getSkills(),
                RoleEnum.ASSASSIN.getBaseHealth(),
                RoleEnum.ASSASSIN.getBaseMana(),
                RoleEnum.ASSASSIN.getBaseAttack(),
                RoleEnum.ASSASSIN.getBaseDefense()
        );
    }

    @Override
    public Skill useSkill(Skill skill) {
        return skill;
    }

    private static List<Skill> getDefaultSkills() {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(
                SkillEnum.VENOMOUS_STRIKE.getId(),
                SkillEnum.VENOMOUS_STRIKE.getName(),
                SkillEnum.VENOMOUS_STRIKE.getDescription(),
                SkillEnum.VENOMOUS_STRIKE.getManaCost(),
                SkillEnum.VENOMOUS_STRIKE.getPower()
        ));
        return skills;
    }
}
