package com.skyrim.rpg.application.controllers;
import com.skyrim.rpg.application.containers.GameContainer;
import com.skyrim.rpg.application.dto.ActionRequestDTO;
import com.skyrim.rpg.application.dto.BattleRequestDTO;
import com.skyrim.rpg.application.dto.LogMessageDTO;
import com.skyrim.rpg.application.exceptions.BattleLogNotAvailableException;
import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.entities.Enemy;
import com.skyrim.rpg.domain.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/battles")
public class BattleController {

    private final GameContainer gameContainer;

    @Autowired
    public BattleController(GameContainer gameContainer) {
        this.gameContainer = gameContainer;
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> startBattle(@RequestBody BattleRequestDTO battleRequest) {
        String characterId = battleRequest.getCharacterId();
        Character player = gameContainer.getCharacterService().findById(characterId);

        if (player == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Character not found with id: " + characterId));
        }

        gameContainer.getBattleService().startBattle(player);

        Enemy enemy = gameContainer.getEnemyFactory().createEnemy(RoleEnum.ENEMY_DRAGON);
        if (enemy == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "No enemy found for battle. Cannot proceed."));
        }

        Map<String, Object> battleData = Map.of("player", player, "enemy", enemy, "battleLog", gameContainer.getBattleService().getBattleLog());

        return ResponseEntity.status(HttpStatus.CREATED).body(battleData);
    }

    @GetMapping("/{characterId}")
    public ResponseEntity<?> getBattleState(@PathVariable String characterId) {
        Character player = gameContainer.getCharacterService().findById(characterId);
        if (player == null) {
            return ResponseEntity.badRequest().body("Player not found with id: " + characterId);
        }

        Enemy enemy = gameContainer.getEnemyFactory().createEnemy(RoleEnum.ENEMY_DRAGON);
        if (enemy == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No enemy found for battle. Cannot proceed.");
        }

        try {
            Map<String, Object> battleData = Map.of("player", player, "enemy", enemy, "battleLog", gameContainer.getBattleService().getBattleLog());

            return ResponseEntity.ok(battleData);
        } catch (NullPointerException e) {
            throw new BattleLogNotAvailableException("Failed to retrieve battle log", e);
        }
    }

    @PostMapping("/{characterId}/action")
    public ResponseEntity<Map<String, Object>> handlePlayerActionChoice(@PathVariable String characterId, @RequestBody ActionRequestDTO actionRequest) {
        try {
            Character player = gameContainer.getCharacterService().findById(characterId);

            if (player == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Character not found with id: " + characterId));
            }

            String action = actionRequest.getAction();
            String skillId = actionRequest.getSkillId();

            gameContainer.getBattleService().performAction(action, skillId);

            Map<String, Object> battleState = gameContainer.getBattleService().getBattleState();

            return ResponseEntity.ok().body(battleState);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/{characterId}/logs")
    public ResponseEntity<?> logMessage(@PathVariable String characterId, @RequestBody LogMessageDTO logMessageDTO) {
        try {
            Character player = gameContainer.getCharacterService().findById(characterId);

            if (player == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Character not found with id: " + characterId));
            }

            gameContainer.getBattleService().logMessage(logMessageDTO.getMessage());

            Map<String, Object> battleState = gameContainer.getBattleService().getBattleState();
            return ResponseEntity.ok(battleState);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{characterId}/logs")
    public ResponseEntity<?> getBattleLogs(@PathVariable String characterId) {
        Character player = gameContainer.getCharacterService().findById(characterId);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Character not found with id: " + characterId);
        }

        List<String> battleLog = gameContainer.getBattleService().getBattleLog();
        if (battleLog.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(battleLog);
    }
}
