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

/**
 * Service class responsible for managing operations related to characters in the RPG game.
 * This includes character creation, retrieval, update, and saving game progress.
 */
@Service
public class CharacterService implements CharacterServiceInterface {
    /**
     * Constructor to initialize CharacterService with repositories.
     *
     * @param characterRepository The repository for managing characters.
     * @param itemRepository      The repository for managing items.
     */
    private final CharacterRepository characterRepository;
    private final ItemRepository itemRepository;

    public CharacterService(CharacterRepository characterRepository, ItemRepository itemRepository) {
        this.characterRepository = characterRepository;
        this.itemRepository = itemRepository;
    }

    /**
     * Retrieves a character by ID.
     *
     * @param id The ID of the character to retrieve.
     * @return The Character object if found, null otherwise.
     */
    @Override
    public Character findById(String id) {
        return characterRepository.findById(id);
    }

    /**
     * Retrieves all characters.
     *
     * @return A list of all characters.
     */
    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    /**
     * Initializes a new character based on the provided parameters.
     *
     * @param name           The name of the character.
     * @param description    The description of the character.
     * @param roleType       The role type (Warrior, Archer, Assassin, Mage) of the character.
     * @param initialItemId  The ID of the initial item for the character.
     * @return The initialized Character object.
     */
    private Character initializeCharacter(String name, String description, RoleEnum roleType, String initialItemId) {
        int level = 1;
        int xpPoints = 0;
        List<Item> items = new ArrayList<>();

        Item initialItem = itemRepository.findById(initialItemId);

        if (initialItem != null) {
            items.add(initialItem);
        }

        return switch (roleType) {
            case WARRIOR -> new Warrior(name, description, level, xpPoints, items, 10);
            case ARCHER -> new Archer(name, description, level, xpPoints, items, 2);
            case ASSASSIN -> new Assassin(name, description, level, xpPoints, items, 5);
            case MAGE -> new Mage(name, description, level, xpPoints, items, 10);
        };
    }

    /**
     * Saves a character.
     *
     * @param character The character to save.
     */
    @Override
    public void save(Character character) {
        characterRepository.save(character);
    }

    /**
     * Initializes a new character based on the provided parameters and saves it.
     *
     * @param name           The name of the character.
     * @param description    The description of the character.
     * @param roleType       The role type (Warrior, Archer, Assassin, Mage) of the character.
     * @param initialItemId  The ID of the initial item for the character.
     * @return The initialized and saved Character object.
     */
    @Override
    public Character initializeAndSaveCharacter(String name, String description, RoleEnum roleType, String initialItemId) {
        Character character = initializeCharacter(name, description, roleType, initialItemId);
        characterRepository.save(character);
        return character;
    }

    /**
     * Updates an existing character with new information.
     *
     * @param characterId    The ID of the character to update.
     * @param name           The new name of the character.
     * @param description    The new description of the character.
     * @param roleType       The new role type of the character.
     */
    @Override
    public void updateCharacter(String characterId, String name, String description, RoleEnum roleType) {
        Character existingCharacter = characterRepository.findById(characterId);
        if (existingCharacter == null) {
            throw new IllegalArgumentException("Character with ID " + characterId + " not found.");
        }

        existingCharacter.setName(name);
        existingCharacter.setDescription(description);
        existingCharacter.setRoleType(roleType);

        characterRepository.save(existingCharacter);
    }

    /**
     * Saves the game progress by updating multiple characters.
     *
     * @param characters The list of characters whose progress to save.
     */
    public void saveGameProgress(List<Character> characters) {
        for (Character character : characters) {
            characterRepository.save(character);
        }
    }
}
