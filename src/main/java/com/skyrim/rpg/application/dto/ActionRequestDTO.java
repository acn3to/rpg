package com.skyrim.rpg.application.dto;

public class ActionRequestDTO {
    private String action;
    private String skillId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }
}
