package com.skyrim.rpg.infrastructure.repositories;

import com.skyrim.rpg.domain.entities.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ItemRepository.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    private Item savedItem;

    @BeforeEach
    void setUp() {
        Item item = new Item("Sword of Skyrim", "A legendary sword with magical powers.", 1000, "Fire Damage", "Inflicts fire damage on the target.", 10);

        savedItem = itemRepository.save(item);
    }

    @Test
    void testSaveItem() {
        Item item = new Item("Sword of Skyrim", "A legendary sword with magical powers.", 1000, "Fire Damage", "Inflicts fire damage on the target.", 10);

        savedItem = itemRepository.save(item);

        assertThat(savedItem).isNotNull();
        assertThat(savedItem.getName()).isEqualTo("Sword of Skyrim");
        assertThat(savedItem.getEffect()).isEqualTo("Fire Damage");
        assertThat(savedItem.getEffectDescription()).isEqualTo("Inflicts fire damage on the target.");
        assertThat(savedItem.getValue()).isEqualTo(1000);
        assertThat(savedItem.getEffectBuff()).isEqualTo(10);
    }

    @Test
    void testFindItem() {
        Item foundItem = itemRepository.findById(savedItem.getId());

        assertThat(foundItem).isNotNull();
        assertThat(foundItem.getId()).isEqualTo(savedItem.getId());
        assertThat(foundItem.getName()).isEqualTo("Sword of Skyrim");
        assertThat(foundItem.getEffect()).isEqualTo("Fire Damage");
        assertThat(foundItem.getEffectDescription()).isEqualTo("Inflicts fire damage on the target.");
        assertThat(foundItem.getValue()).isEqualTo(1000);
        assertThat(foundItem.getEffectBuff()).isEqualTo(10);
    }

    @Test
    void testUpdateItem() {
        savedItem.setName("Updated Sword");
        savedItem.setValue(1200);

        itemRepository.update(savedItem);

        Item updatedItem = itemRepository.findById(savedItem.getId());

        assertThat(updatedItem).isNotNull();
        assertThat(updatedItem.getId()).isEqualTo(savedItem.getId());
        assertThat(updatedItem.getName()).isEqualTo("Updated Sword");
        assertThat(updatedItem.getValue()).isEqualTo(1200);
    }

    @Test
    void testDeleteItem() {
        itemRepository.delete(savedItem);

        Item deletedItem = itemRepository.findById(savedItem.getId());
        assertThat(deletedItem).isNull();
    }

    @Test
    void testUpdateNonExistingItem() {
        Item newItem = new Item("Staff of Magnus", "A powerful staff that controls magic.", 1500, "Magic Damage", "Inflicts magic damage on the target.", 15);

        assertThrows(IllegalArgumentException.class, () -> {
            itemRepository.update(newItem);
        });
    }

    @Test
    void testDeleteNonExistingItem() {
        Item newItem = new Item("Staff of Magnus", "A powerful staff that controls magic.", 1500, "Magic Damage", "Inflicts magic damage on the target.", 15);

        assertThrows(IllegalArgumentException.class, () -> {
            itemRepository.delete(newItem);
        });
    }
}
