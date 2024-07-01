package com.skyrim.rpg.domain.roles;

import com.skyrim.rpg.domain.entities.Role;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.domain.enums.SkillEnum;

import java.util.ArrayList;
import java.util.List;

public class ArcherRole extends Role {
    private int dexterity;

    public ArcherRole(int id, String name, String description, List<Skill> skills, int baseHealth, int baseMana, int baseAttack, int baseDefense, int dexterity) {
        super(
                RoleEnum.ARCHER.getId(),
                RoleEnum.ARCHER.getName(),
                RoleEnum.ARCHER.getDescription(),
                RoleEnum.ARCHER.getSkills(),
                RoleEnum.ARCHER.getBaseHealth(),
                RoleEnum.ARCHER.getBaseMana(),
                RoleEnum.ARCHER.getBaseAttack(),
                RoleEnum.ARCHER.getBaseDefense()
        );
        this.dexterity = dexterity;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public Skill useSkill(Skill skill) {
        return skill;
    }

    private static List<Skill> getDefaultSkills() {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(
                SkillEnum.PRECISION_SHOT.getId(),
                SkillEnum.PRECISION_SHOT.getName(),
                SkillEnum.PRECISION_SHOT.getType(),
                SkillEnum.PRECISION_SHOT.getDescription(),
                SkillEnum.PRECISION_SHOT.getManaCost(),
                SkillEnum.PRECISION_SHOT.getPower()
                ));
        return skills;
    }

    @Override
    public String toString() {
        return "ArcherRole{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", skills=" + getSkills() +
                ", baseHealth=" + getBaseHealth() +
                ", baseMana=" + getBaseMana() +
                ", baseAttack=" + getBaseAttack() +
                ", baseDefense=" + getBaseDefense() +
                ", dexterity=" + getDexterity() +
                '}';
    }
}
