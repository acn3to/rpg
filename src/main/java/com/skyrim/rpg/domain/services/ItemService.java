package com.skyrim.rpg.domain.services;

import com.skyrim.rpg.domain.entities.DaedricArtifact;
import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.interfaces.services.ItemServiceInterface;
import com.skyrim.rpg.infrastructure.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemServiceInterface {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(String itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public Item createItem(String name, String description, int value, String effect, String effectDescription, int effectBuff) {
        Item newItem = new Item(name, description, value, effect, effectDescription, effectBuff);
        itemRepository.save(newItem);
        return newItem;
    }

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

    @Override
    public void deleteItem(String itemId) {
        Item itemToDelete = itemRepository.findById(itemId);
        if (itemToDelete != null) {
            itemRepository.delete(itemToDelete);
        } else {
            throw new IllegalArgumentException("Item not found with id: " + itemId);
        }
    }

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
