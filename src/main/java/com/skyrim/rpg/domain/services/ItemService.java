package com.skyrim.rpg.domain.services;

import com.skyrim.rpg.domain.entities.DaedricArtifact;
import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.interfaces.services.ItemServiceInterface;
import com.skyrim.rpg.infrastructure.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for managing operations related to items in the RPG game.
 * This includes operations for items and handling special skills for DaedricArtifact items.
 */
@Service
public class ItemService implements ItemServiceInterface {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * Retrieves all items from the database.
     *
     * @return List of all items.
     */
    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    /**
     * Retrieves an item by its unique ID.
     *
     * @param itemId The ID of the item to retrieve.
     * @return The Item object if found, null otherwise.
     */
    @Override
    public Item getItemById(String itemId) {
        return itemRepository.findById(itemId);
    }

    /**
     * Creates a new item with the specified attributes and saves it to the database.
     *
     * @param name             The name of the item.
     * @param description      The description of the item.
     * @param value            The value or price of the item.
     * @param effect           The effect or ability provided by the item.
     * @param effectDescription The description of the effect provided by the item.
     * @param effectBuff       The strength or magnitude of the effect.
     * @return The newly created Item object.
     */
    @Override
    public Item createItem(String name, String description, int value, String effect, String effectDescription, int effectBuff) {
        Item newItem = new Item(name, description, value, effect, effectDescription, effectBuff);
        itemRepository.save(newItem);
        return newItem;
    }

    /**
     * Updates an existing item with new attributes.
     *
     * @param itemId           The ID of the item to update.
     * @param name             The new name of the item.
     * @param description      The new description of the item.
     * @param value            The new value or price of the item.
     * @param effect           The new effect or ability provided by the item.
     * @param effectDescription The new description of the effect provided by the item.
     * @param effectBuff       The new strength or magnitude of the effect.
     * @throws IllegalArgumentException If the item with the given ID does not exist.
     */
    public void updateItem(String itemId, String name, String description, int value, String effect, String effectDescription, int effectBuff) {
        Item itemToUpdate = itemRepository.findById(itemId);
        if (itemToUpdate != null) {
            itemToUpdate.setName(name);
            itemToUpdate.setDescription(description);
            itemToUpdate.setValue(value);
            itemToUpdate.setEffect(effect);
            itemToUpdate.setEffectDescription(effectDescription);
            itemToUpdate.setEffectBuff(effectBuff);
            itemRepository.update(itemToUpdate);
        } else {
            throw new IllegalArgumentException("Item not found with id: " + itemId);
        }
    }

    /**
     * Deletes an item from the database.
     *
     * @param itemId The ID of the item to delete.
     * @throws IllegalArgumentException If the item with the given ID does not exist.
     */
    @Override
    public void deleteItem(String itemId) {
        Item itemToDelete = itemRepository.findById(itemId);
        if (itemToDelete != null) {
            itemRepository.delete(itemToDelete);
        } else {
            throw new IllegalArgumentException("Item not found with id: " + itemId);
        }
    }

    /**
     * Adds special skills to a DaedricArtifact item.
     *
     * @param itemId       The ID of the DaedricArtifact item to update.
     * @param specialSkills The list of special skills to add.
     * @throws IllegalArgumentException If the item with the given ID is not a DaedricArtifact.
     */
    @Override
    public void addSpecialSkills(String itemId, List<Skill> specialSkills) {
        Item itemToUpdate = itemRepository.findById(itemId);
        if (itemToUpdate instanceof DaedricArtifact) {
            ((DaedricArtifact) itemToUpdate).setSpecialSkills(specialSkills);
            itemRepository.update(itemToUpdate);
        } else {
            throw new IllegalArgumentException("Item with id: " + itemId + " is not a DaedricArtifact.");
        }
    }

    /**
     * Removes specific special skills from a DaedricArtifact item.
     *
     * @param itemId       The ID of the DaedricArtifact item to update.
     * @param specialSkills The list of special skills to remove.
     * @throws IllegalArgumentException If the item with the given ID is not a DaedricArtifact.
     */
    @Override
    public void removeSpecialSkills(String itemId, List<Skill> specialSkills) {
        Item itemToUpdate = itemRepository.findById(itemId);
        if (itemToUpdate instanceof DaedricArtifact) {
            ((DaedricArtifact) itemToUpdate).getSpecialSkills().removeAll(specialSkills);
            itemRepository.update(itemToUpdate);
        } else {
            throw new IllegalArgumentException("Item with id: " + itemId + " is not a DaedricArtifact.");
        }
    }
}
