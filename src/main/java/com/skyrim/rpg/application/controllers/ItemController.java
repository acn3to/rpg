package com.skyrim.rpg.application.controllers;

import com.skyrim.rpg.application.containers.GameContainer;
import com.skyrim.rpg.application.dto.CreateItemDTO;
import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.domain.enums.ItemEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/items")
public class ItemController {

    private final GameContainer gameContainer;

    @Autowired
    public ItemController(GameContainer gameContainer) {
        this.gameContainer = gameContainer;
    }

    @PostMapping("/initialize")
    public ResponseEntity<String> initializeItems() {
        try {
            for (ItemEnum itemEnum : ItemEnum.values()) {
                gameContainer.getItemService().createItem(
                        itemEnum.getItem().getName(),
                        itemEnum.getItem().getDescription(),
                        itemEnum.getItem().getValue(),
                        itemEnum.getItem().getEffect(),
                        itemEnum.getItem().getEffectDescription(),
                        itemEnum.getItem().getEffectBuff()
                );
            }
            return ResponseEntity.ok("Initial items created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to initialize items: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody CreateItemDTO createItemDTO) {
        Item createdItem = gameContainer.getItemService().createItem(
                createItemDTO.getName(),
                createItemDTO.getDescription(),
                createItemDTO.getValue(),
                createItemDTO.getEffectName(),
                createItemDTO.getEffectDescription(),
                createItemDTO.getEffectValue()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = gameContainer.getItemService().getAllItems();
        return ResponseEntity.ok(items);
    }

}
