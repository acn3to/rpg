package com.skyrim.rpg.domain.entities;

import com.skyrim.rpg.domain.enums.EffectEnum;

import java.util.List;

public class DaedricArtifact extends Item {
    private List<Skill> specialSkills;

    public DaedricArtifact(String name, String description, int value, EffectEnum effect, List<Skill> specialSkills) {
        super(name, description, value, effect);
        this.specialSkills = specialSkills;
    }

    public List<Skill> getSpecialSkills() {
        return specialSkills;
    }

    public void setSpecialSkills(List<Skill> specialSkills) {
        this.specialSkills = specialSkills;
    }

    @Override
    public String toString() {
        return "DaedricArtifact{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", value=" + getValue() +
                ", effect=" + getEffect() +
                ", specialSkills=" + specialSkills +
                '}';
    }
}
