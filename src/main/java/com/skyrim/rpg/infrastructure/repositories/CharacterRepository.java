package com.skyrim.rpg.infrastructure.repositories;

import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.infrastructure.interfaces.CharacterRepositoryInterface;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Repository class responsible for managing CRUD operations for characters in memory.
 */
@Component
public class CharacterRepository implements CharacterRepositoryInterface {

    private final Map<String, Character> characterMap = new HashMap<>();

    /**
     * Retrieves a character by ID.
     *
     * @param id The ID of the character to retrieve.
     * @return The Character object if found, null otherwise.
     * @throws IllegalArgumentException if the provided ID is null.
     */
    @Override
    public Character findById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }
        return characterMap.get(id);
    }

    /**
     * Retrieves all characters.
     *
     * @return A list of all Character objects.
     */
    @Override
    public List<Character> findAll() {
        return new ArrayList<>(characterMap.values());
    }

    /**
     * Saves a character.
     *
     * @param character The character object to save.
     * @throws IllegalArgumentException if the provided character is null.
     */
    @Override
    public void save(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be null.");
        }
        characterMap.put(character.getId(), character);
    }

    /**
     * Updates a character.
     *
     * @param character The character object to update.
     * @throws IllegalArgumentException if the provided character is null or if the character with the specified ID is not found.
     */
    @Override
    public void update(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be null.");
        }
        if (characterMap.containsKey(character.getId())) {
            characterMap.put(character.getId(), character);
        } else {
            throw new IllegalArgumentException("Character with ID " + character.getId() + " not found, cannot update.");
        }
    }

    /**
     * Deletes a character.
     *
     * @param character The character object to delete.
     * @throws IllegalArgumentException if the provided character is null.
     */
    @Override
    public void delete(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be null.");
        }
        characterMap.remove(character.getId());
    }
}
