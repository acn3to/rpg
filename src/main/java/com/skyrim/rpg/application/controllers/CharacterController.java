package com.skyrim.rpg.application.controllers;

import com.skyrim.rpg.application.containers.GameContainer;
import com.skyrim.rpg.application.dto.CreateCharacterDTO;
import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/characters")
public class CharacterController {

    private final GameContainer gameContainer;

    @Autowired
    public CharacterController(GameContainer gameContainer) {
        this.gameContainer = gameContainer;
    }

    @PostMapping("/create")
    public ResponseEntity<Character> createCharacter(@RequestBody CreateCharacterDTO createCharacterDTO) {
        try {
            RoleEnum role = RoleEnum.valueOf(createCharacterDTO.getRole().toUpperCase());

            Character createdCharacter = gameContainer.getCharacterService().initializeAndSaveCharacter(createCharacterDTO.getName(), createCharacterDTO.getDescription(), role, createCharacterDTO.getInitialItemId());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCharacter);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
