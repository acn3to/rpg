package com.skyrim.rpg.domain.interfaces.services;

import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.enums.RoleEnum;

import java.util.List;

public interface CharacterServiceInterface {
    Character findById(String id);
    void save(Character character);
    Character initializeAndSaveCharacter(String name, String description, RoleEnum role, String initialItemId);
    void updateCharacter(String characterId, String name, String description, RoleEnum role);
    List<Character> getAllCharacters();
    void saveGameProgress(List<Character> characters);
}
