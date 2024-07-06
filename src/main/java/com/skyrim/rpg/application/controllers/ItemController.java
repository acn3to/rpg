package com.skyrim.rpg.application.controllers;

import com.skyrim.rpg.application.containers.GameContainer;
import com.skyrim.rpg.application.dto.CreateItemDTO;
import com.skyrim.rpg.domain.entities.Item;
import com.skyrim.rpg.application.exceptions.ItemInitializationException;
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

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody CreateItemDTO createItemDTO) {
        try {
            Item createdItem = gameContainer.getItemService().createItem(
                    createItemDTO.getName(),
                    createItemDTO.getDescription(),
                    createItemDTO.getValue(),
                    createItemDTO.getEffectName(),
                    createItemDTO.getEffectDescription(),
                    createItemDTO.getEffectValue()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        try {
            List<Item> items = gameContainer.getItemService().getAllItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
