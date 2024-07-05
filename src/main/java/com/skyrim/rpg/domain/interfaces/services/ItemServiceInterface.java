package com.skyrim.rpg.domain.interfaces.services;

import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.domain.entities.Skill;

import java.util.List;

public interface ItemServiceInterface {
    List<Item> getAllItems();
    Item getItemById(String itemId);
    Item createItem(String name, String description, int value, String effect, String effectDescription, int effectBuff);
    void updateItem(String itemId, String name, String description, int value, String effect, String effectDescription, int effectBuff);
    void deleteItem(String itemId);
    void addSpecialSkills(String itemId, List<Skill> specialSkills);
    void removeSpecialSkills(String itemId, List<Skill> specialSkills);
}
