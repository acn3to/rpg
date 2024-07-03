package com.skyrim.rpg.application.controllers;

import com.skyrim.rpg.application.dto.CharacterRequest;
import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final CharacterService characterService;

    @Autowired
    public GameController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Skyrim RPG!";
    }

    @PostMapping("/character")
    public Character createCharacter(@RequestBody CharacterRequest characterRequest) {
        String name = characterRequest.getName();
        String description = characterRequest.getDescription();
        String roleName = characterRequest.getRoleName();

        return characterService.initializeAndSaveCharacter(name, description, roleName);
    }

    @GetMapping("/character/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return characterService.findById(id);
    }
}
