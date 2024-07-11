package com.skyrim.rpg.infrastructure.repositories;

import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.infrastructure.interfaces.ItemRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repository class responsible for managing CRUD operations for items in memory.
 */
@Repository
public class ItemRepository implements ItemRepositoryInterface {

    private final Map<String, Item> itemMap = new HashMap<>();

    /**
     * Retrieves an item by ID.
     *
     * @param id The ID of the item to retrieve.
     * @return The Item object if found, null otherwise.
     * @throws IllegalArgumentException if the provided ID is null.
     */
    @Override
    public Item findById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }
        return itemMap.get(id);
    }

    /**
     * Retrieves all items.
     *
     * @return A list of all Item objects.
     */
    @Override
    public List<Item> findAll() {
        return new ArrayList<>(itemMap.values());
    }

    /**
     * Saves an item.
     *
     * @param item The item object to save.
     * @return The saved Item object.
     * @throws IllegalArgumentException if the provided item is null.
     */
    @Override
    public Item save(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        itemMap.put(item.getId(), item);
        return item;
    }

    /**
     * Updates an item.
     *
     * @param item The item object to update.
     * @throws IllegalArgumentException if the provided item is null or if the item with the specified ID is not found.
     */
    @Override
    public void update(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        if (itemMap.containsKey(item.getId())) {
            itemMap.put(item.getId(), item);
        } else {
            throw new IllegalArgumentException("Item with ID " + item.getId() + " not found, cannot update.");
        }
    }

    /**
     * Deletes an item.
     *
     * @param item The item object to delete.
     * @throws IllegalArgumentException if the provided item is null or if the item with the specified ID is not found.
     */
    @Override
    public void delete(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        if (!itemMap.containsKey(item.getId())) {
            throw new IllegalArgumentException("Item with ID " + item.getId() + " not found, cannot delete.");
        }
        itemMap.remove(item.getId());
    }
}
