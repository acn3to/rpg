package com.skyrim.rpg.domain.interfaces.services;

import com.skyrim.rpg.domain.entities.Character;

import java.util.List;

public interface CharacterServiceInterface {
    Character findById(String id);
    void save(Character character);
    Character initializeAndSaveCharacter(String name, String description, String role, String initialItemId);
    void updateCharacter(String characterId, String name, String description, String role);
    void saveGameProgress(List<Character> characters);
}
