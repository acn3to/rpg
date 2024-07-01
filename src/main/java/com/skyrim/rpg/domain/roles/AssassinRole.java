package com.skyrim.rpg.domain.roles;

import com.skyrim.rpg.domain.entities.Role;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.ArrayList;
import java.util.List;

public class AssassinRole extends Role {
    private int agility;

    public AssassinRole(int id, String name, String description, List<Skill> skills, int baseHealth, int baseMana, int baseAttack, int baseDefense, int agility) {
        super(
                RoleEnum.ASSASSIN.getId(),
                RoleEnum.ASSASSIN.getName(),
                RoleEnum.ASSASSIN.getDescription(),
                RoleEnum.ASSASSIN.getSkills(),
                RoleEnum.ASSASSIN.getBaseHealth(),
                RoleEnum.ASSASSIN.getBaseMana(),
                RoleEnum.ASSASSIN.getBaseAttack(),
                RoleEnum.ASSASSIN.getBaseDefense()
        );
        this.agility = agility;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
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
                SkillEnum.VENOMOUS_STRIKE.getType(),
                SkillEnum.VENOMOUS_STRIKE.getDescription(),
                SkillEnum.VENOMOUS_STRIKE.getManaCost(),
                SkillEnum.VENOMOUS_STRIKE.getPower()
        ));
        return skills;
    }

    @Override
    public String toString() {
        return "AssassinRole{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", skills=" + getSkills() +
                ", baseHealth=" + getBaseHealth() +
                ", baseMana=" + getBaseMana() +
                ", baseAttack=" + getBaseAttack() +
                ", baseDefense=" + getBaseDefense() +
                ", agility=" + getAgility() +
                '}';
    }
}
