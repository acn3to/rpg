package com.skyrim.rpg.domain.services;

import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.infrastructure.repositories.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ItemRepository.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    private Item savedItem;

    @BeforeEach
    void setUp() {
        // Create an Item instance
        Item item = new Item("Sword of Skyrim", "A legendary sword with magical powers.", 1000, "Fire Damage", "Inflicts fire damage on the target.", 10);

        // Save the Item to the repository
        savedItem = itemRepository.save(item);
    }

    @Test
    void testSaveItem() {
        // Create an Item instance for comparison
        Item item = new Item("Sword of Skyrim", "A legendary sword with magical powers.", 1000, "Fire Damage", "Inflicts fire damage on the target.", 10);

        // Save the Item to the repository
        savedItem = itemRepository.save(item);

        // Assert that savedItem is not null
        assertThat(savedItem).isNotNull();

        // Assert that the attributes of savedItem match the expected values
        assertThat(savedItem.getName()).isEqualTo("Sword of Skyrim");
        assertThat(savedItem.getEffect()).isEqualTo("Fire Damage");
        assertThat(savedItem.getEffectDescription()).isEqualTo("Inflicts fire damage on the target.");
        assertThat(savedItem.getValue()).isEqualTo(1000);
        assertThat(savedItem.getEffectBuff()).isEqualTo(10);
    }

    @Test
    void testFindItem() {
        // Retrieve the saved item from the repository
        Item foundItem = itemRepository.findById(savedItem.getId());

        // Assert that foundItem is not null
        assertThat(foundItem).isNotNull();

        // Assert that the attributes of foundItem match the expected values
        assertThat(foundItem.getId()).isEqualTo(savedItem.getId());
        assertThat(foundItem.getName()).isEqualTo("Sword of Skyrim");
        assertThat(foundItem.getEffect()).isEqualTo("Fire Damage");
        assertThat(foundItem.getEffectDescription()).isEqualTo("Inflicts fire damage on the target.");
        assertThat(foundItem.getValue()).isEqualTo(1000);
        assertThat(foundItem.getEffectBuff()).isEqualTo(10);
    }
}
