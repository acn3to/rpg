package com.skyrim.rpg.application.containers;

import com.skyrim.rpg.domain.factories.EnemyFactory;
import com.skyrim.rpg.domain.services.BattleService;
import com.skyrim.rpg.domain.services.CharacterService;
import com.skyrim.rpg.domain.services.ItemService;
import com.skyrim.rpg.infrastructure.repositories.CharacterRepository;
import com.skyrim.rpg.infrastructure.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GameContainer {

    private final CharacterService characterService;
    private final ItemService itemService;
    private final BattleService battleService;
    private final EnemyFactory enemyFactory;
    private final CharacterRepository characterRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public GameContainer(CharacterService characterService, ItemService itemService, BattleService battleService, EnemyFactory enemyFactory, CharacterRepository characterRepository, ItemRepository itemRepository) {
        this.characterService = characterService;
        this.itemService = itemService;
        this.battleService = battleService;
        this.enemyFactory = enemyFactory;
        this.characterRepository = characterRepository;
        this.itemRepository = itemRepository;
    }

    public CharacterService getCharacterService() {
        return characterService;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public BattleService getBattleService() {
        return battleService;
    }

    public EnemyFactory getEnemyFactory() {
        return enemyFactory;
    }

    public CharacterRepository getCharacterRepository() {
        return characterRepository;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }
}
