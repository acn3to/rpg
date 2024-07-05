package com.skyrim.rpg.infrastructure.repositories;

import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.infrastructure.interfaces.CharacterRepositoryInterface;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CharacterRepository implements CharacterRepositoryInterface {

    private final Map<String, Character> characterMap = new HashMap<>();

    @Override
    public Character findById(String id) {
        return characterMap.get(id);
    }

    @Override
    public List<Character> findAll() {
        return new ArrayList<>(characterMap.values());
    }

    @Override
    public void save(Character character) {
        characterMap.put(character.getId(), character);
    }

    @Override
    public void update(Character character) {
        if (characterMap.containsKey(character.getId())) {
            characterMap.put(character.getId(), character);
        } else {
            throw new IllegalArgumentException("Character with ID " + character.getId() + " not found, cannot update.");
        }
    }

    @Override
    public void delete(Character character) {
        characterMap.remove(character.getId());
    }
}
