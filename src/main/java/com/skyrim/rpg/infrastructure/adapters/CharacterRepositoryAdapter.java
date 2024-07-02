package com.skyrim.rpg.infrastructure.adapters;

import com.skyrim.rpg.domain.entities.Character;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CharacterRepositoryAdapter {
    private final Map<Long, Character> characterMap = new HashMap<>();
    private Long currentId = 1L;

    public void save(Character character) {
        character.setId(String.valueOf(currentId));
        characterMap.put(currentId++, character);
    }

    public List<Character> findAll() {
        return new ArrayList<>(characterMap.values());
    }

    public Character findById(Long id) {
        return characterMap.get(id);
    }

    public void delete(Long id) {
        characterMap.remove(id);
    }
}
