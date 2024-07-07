package com.skyrim.rpg.application.controllers;

import com.skyrim.rpg.application.containers.GameContainer;
import com.skyrim.rpg.application.dto.CreateItemDTO;
import com.skyrim.rpg.domain.entities.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/items", produces = {"application/json"})
@Tag(name = "rpg-api")
public class ItemController {

    private final GameContainer gameContainer;

    @Autowired
    public ItemController(GameContainer gameContainer) {
        this.gameContainer = gameContainer;
    }

    @Operation(summary = "Creates a new item", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
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
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Retrieves all items", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Items retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        try {
            List<Item> items = gameContainer.getItemService().getAllItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
