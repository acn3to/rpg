package com.skyrim.rpg.infrastructure.interfaces;

import com.skyrim.rpg.domain.entities.Character;

import java.util.List;

public interface CharacterRepositoryInterface {
    Character findById(String id);
    List<Character> findAll();
    void save(Character character);
    void update(Character character);
    void delete(Character character);
}
