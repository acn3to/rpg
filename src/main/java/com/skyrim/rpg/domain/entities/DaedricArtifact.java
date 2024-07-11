package com.skyrim.rpg.domain.entities;

import java.util.List;

/**
 * Represents a Daedric Artifact in the game, extending the Item class.
 */
public class DaedricArtifact extends Item {
    private List<Skill> specialSkills;

    /**
     * Constructs a DaedricArtifact object with specified attributes.
     *
     * @param name              The name of the Daedric Artifact.
     * @param description       The description of the Daedric Artifact.
     * @param value             The value of the Daedric Artifact.
     * @param effect            The effect type of the Daedric Artifact.
     * @param effectDescription The description of the effect of the Daedric Artifact.
     * @param effectBuff        The effect buff value of the Daedric Artifact.
     * @param specialSkills     The special skills associated with the Daedric Artifact.
     */
    public DaedricArtifact(String name, String description, int value, String effect, String effectDescription, int effectBuff, List<Skill> specialSkills) {
        super(name, description, value, effect, effectDescription, effectBuff);
        this.specialSkills = specialSkills;
    }

    /**
     * Retrieves the list of special skills associated with the Daedric Artifact.
     *
     * @return The list of special skills.
     */
    public List<Skill> getSpecialSkills() {
        return specialSkills;
    }

    /**
     * Sets the list of special skills associated with the Daedric Artifact.
     *
     * @param specialSkills The list of special skills.
     */
    public void setSpecialSkills(List<Skill> specialSkills) {
        this.specialSkills = specialSkills;
    }

    /**
     * Returns a string representation of the DaedricArtifact object.
     *
     * @return A string representation of the DaedricArtifact object.
     */
    @Override
    public String toString() {
        return "DaedricArtifact{" +
                "specialSkills=" + getSpecialSkills() +
                '}';
    }
}
