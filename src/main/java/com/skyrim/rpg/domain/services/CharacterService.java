package com.skyrim.rpg.domain.services;

import com.skyrim.rpg.domain.entities.*;
import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.enums.RoleEnum;
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

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public void save(Character character) {
        characterRepository.save(character);
    }

    public Character initializeAndSaveCharacter(String name, String description, RoleEnum role, String initialItemId) {
        Character character = initializeCharacter(name, description, role, initialItemId);
        characterRepository.save(character);
        return character;
    }

    private Character initializeCharacter(String name, String description, RoleEnum role, String initialItemId) {
        int level = 1;
        int xpPoints = 0;
        List<Item> items = new ArrayList<>();

        Item initialItem = itemRepositoryAdapter.findById(initialItemId);

        if (initialItem != null) {
            items.add(initialItem);
        }

        switch (role) {
            case WARRIOR:
                return new Warrior(name, description, level, xpPoints, items, new ArrayList<>(), role, 10);
            case ARCHER:
                return new Archer(name, description, level, xpPoints, items, new ArrayList<>(), role, 2);
            case ASSASSIN:
                return new Assassin(name, description, level, xpPoints, items, new ArrayList<>(), role, 5);
            case MAGE:
                return new Mage(name, description, level, xpPoints, items, new ArrayList<>(), role, 10);
            default:
                throw new IllegalArgumentException("Unsupported role: " + role);
        }
    }

    public void updateCharacter(String characterId, String name, String description, RoleEnum role) {
        Character existingCharacter = characterRepository.findById(characterId);
        if (existingCharacter == null) {
            throw new IllegalArgumentException("Character with ID " + characterId + " not found.");
        }

        existingCharacter.setName(name);
        existingCharacter.setDescription(description);
        existingCharacter.setRole(role);

        characterRepository.save(existingCharacter);
    }

    public void saveGameProgress(List<Character> characters) {
        for (Character character : characters) {
            characterRepository.save(character);
        }
    }
}
