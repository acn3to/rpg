package com.skyrim.rpg.application.dto;

public class CreateCharacterDTO {
    private String name;
    private String description;
    private String role;
    private String initialItemId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getInitialItemId() {
        return initialItemId;
    }

    public void setInitialItemId(String initialItemId) {
        this.initialItemId = initialItemId;
    }
}
