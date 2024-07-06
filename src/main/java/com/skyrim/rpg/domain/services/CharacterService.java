package com.skyrim.rpg.domain.services;

import com.skyrim.rpg.domain.entities.*;
import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.interfaces.services.CharacterServiceInterface;
import com.skyrim.rpg.infrastructure.repositories.CharacterRepository;
import com.skyrim.rpg.infrastructure.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements CharacterServiceInterface {
    private final CharacterRepository characterRepository;
    private final ItemRepository itemRepositoryAdapter;

    public CharacterService(CharacterRepository characterRepositoryAdapter, ItemRepository itemRepositoryAdapter) {
        this.characterRepository = characterRepositoryAdapter;
        this.itemRepositoryAdapter = itemRepositoryAdapter;
    }

    public Character findById(String id) {
        return characterRepository.findById(id);
    }

    @Override
    public void save(Character character) {
        characterRepository.save(character);
    }

    @Override
    public Character initializeAndSaveCharacter(String name, String description, String roleType, String initialItemId) {
        Character character = initializeCharacter(name, description, roleType, initialItemId);
        characterRepository.save(character);
        return character;
    }

    @Override
    public void updateCharacter(String characterId, String name, String description, String roleType) {
        Character existingCharacter = characterRepository.findById(characterId);
        if (existingCharacter == null) {
            throw new IllegalArgumentException("Character with ID " + characterId + " not found.");
        }

        existingCharacter.setName(name);
        existingCharacter.setDescription(description);
        existingCharacter.setRoleType(roleType);

        characterRepository.save(existingCharacter);
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    private Character initializeCharacter(String name, String description, String roleType, String initialItemId) {
        int level = 1;
        int xpPoints = 0;
        List<Item> items = new ArrayList<>();

        Item initialItem = itemRepositoryAdapter.findById(initialItemId);

        if (initialItem != null) {
            items.add(initialItem);
        }

        switch (roleType.toUpperCase()) {
            case "WARRIOR":
                return new Warrior(name, description, level, xpPoints, items, new ArrayList<>(), roleType, 10);
            case "ARCHER":
                return new Archer(name, description, level, xpPoints, items, new ArrayList<>(), roleType, 2);
            case "ASSASSIN":
                return new Assassin(name, description, level, xpPoints, items, new ArrayList<>(), roleType, 5);
            case "MAGE":
                return new Mage(name, description, level, xpPoints, items, new ArrayList<>(), roleType, 10);
            default:
                throw new IllegalArgumentException("Unsupported role: " + roleType);
        }
    }

    public void saveGameProgress(List<Character> characters) {
        for (Character character : characters) {
            characterRepository.save(character);
        }
    }
}
