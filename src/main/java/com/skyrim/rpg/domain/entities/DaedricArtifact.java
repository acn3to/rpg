package com.skyrim.rpg.domain.entities;

import java.util.List;

public class DaedricArtifact extends Item {
    private List<Skill> specialSkills;

    public DaedricArtifact(String name, String description, int value, String effect, String effectDescription, int effectBuff, List<Skill> specialSkills) {
        super(name, description, value, effect, effectDescription, effectBuff);
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
                "specialSkills=" + getSpecialSkills() +
                '}';
    }
}
