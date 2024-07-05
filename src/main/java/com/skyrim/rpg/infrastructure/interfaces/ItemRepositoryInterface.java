package com.skyrim.rpg.infrastructure.interfaces;
import com.skyrim.rpg.domain.entities.Item;

import java.util.List;

public interface ItemRepositoryInterface {
    Item findById(String id);
    List<Item> findAll();
    Item save(Item item);
    void update(Item item);
    void delete(Item item);
}
