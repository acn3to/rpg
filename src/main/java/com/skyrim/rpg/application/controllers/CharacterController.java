package com.skyrim.rpg.application.controllers;

import com.skyrim.rpg.application.containers.GameContainer;
import com.skyrim.rpg.application.dto.CreateCharacterDTO;
import com.skyrim.rpg.domain.entities.Character;
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
@RequestMapping(value = "/v1/characters", produces = {"application/json"})
@Tag(name = "rpg-api")
public class CharacterController {

    private final GameContainer gameContainer;

    @Autowired
    public CharacterController(GameContainer gameContainer) {
        this.gameContainer = gameContainer;
    }

    @Operation(summary = "Creates a playable character", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Character successfully created"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Character> createCharacter(@RequestBody CreateCharacterDTO createCharacterDTO) {
        try {
            Character createdCharacter = gameContainer.getCharacterService().initializeAndSaveCharacter(createCharacterDTO.getName(), createCharacterDTO.getDescription(), createCharacterDTO.getRole(), createCharacterDTO.getInitialItemId());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCharacter);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Retrieves all characters", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Characters retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @GetMapping()
    public ResponseEntity<List<Character>> getAllCharacters() {
        try {
            List<Character> characters = gameContainer.getCharacterService().getAllCharacters();
            return ResponseEntity.ok(characters);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
