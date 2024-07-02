package com.skyrim.rpg.domain.services;

import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.ItemEnum;
import com.skyrim.rpg.domain.enums.RoleEnum;
import com.skyrim.rpg.infrastructure.adapters.CharacterRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharacterRepositoryAdapter characterRepositoryAdapter;

    @Autowired
    public CharacterService(CharacterRepositoryAdapter characterRepositoryAdapter) {
        this.characterRepositoryAdapter = characterRepositoryAdapter;
    }

    public Character findById(Long id) {
        return characterRepositoryAdapter.findById(id);
    }

    public Character initializeAndSaveCharacter(String name, String description, String roleName) {
        RoleEnum role = RoleEnum.valueOf(roleName.toUpperCase());
        Character character = initializeCharacter(name, description, role);
        characterRepositoryAdapter.save(character);
        return character;
    }

    private Character initializeCharacter(String name, String description, RoleEnum role) {
        UUID id = UUID.randomUUID();
        int level = 1;
        int xpPoints = 0;
        List<ItemEnum> initialItems = getInitialItemsForRole(role);
        List<Item> items = createItems(initialItems);
        List<Skill> skills = new ArrayList<>();

        return new Character(id.toString(), name, description, level, xpPoints, items, skills, role);
    }

    private List<ItemEnum> getInitialItemsForRole(RoleEnum role) {
        switch (role) {
            case WARRIOR:
                return List.of(ItemEnum.BATTLE_AXE_OF_RAGE, ItemEnum.RING_OF_DEFENSE);
            case MAGE:
                return List.of(ItemEnum.STAFF_OF_MANA_REGENERATION, ItemEnum.AMULET_OF_INTELLECT);
            case ARCHER:
                return List.of(ItemEnum.DAGGER_OF_NIGHT_MOTHER, ItemEnum.ELIXIR_OF_STAMINA);
            case ASSASSIN:
                return List.of(ItemEnum.VENOMOUS_DAGGER, ItemEnum.ELIXIR_OF_STAMINA);
            default:
                return List.of();
        }
    }


    private List<Item> createItems(List<ItemEnum> itemEnums) {
        List<Item> items = new ArrayList<>();
        for (ItemEnum itemEnum : itemEnums) {
            items.add(new Item(
                    itemEnum.getName(),
                    itemEnum.getDescription(),
                    itemEnum.getValue(),
                    itemEnum.getEffect()
            ));
        }
        return items;
    }
}
