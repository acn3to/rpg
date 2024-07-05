package com.skyrim.rpg.infrastructure.repositories;

import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.infrastructure.interfaces.ItemRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository implements ItemRepositoryInterface {

    private final Map<String, Item> itemMap = new HashMap<>();

    @Override
    public Item findById(String id) {
        return itemMap.get(id);
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(itemMap.values());
    }

    @Override
    public Item save(Item item) {
        itemMap.put(item.getId(), item);
        return item;
    }

    @Override
    public void update(Item item) {
        if (itemMap.containsKey(item.getId())) {
            itemMap.put(item.getId(), item);
        } else {
            throw new IllegalArgumentException("Item with ID " + item.getId() + " not found, cannot update.");
        }
    }

    @Override
    public void delete(Item item) {
        itemMap.remove(item.getId());
    }
}
