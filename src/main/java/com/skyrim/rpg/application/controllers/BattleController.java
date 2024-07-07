package com.skyrim.rpg.application.controllers;

import com.skyrim.rpg.application.containers.GameContainer;
import com.skyrim.rpg.application.dto.ActionRequestDTO;
import com.skyrim.rpg.application.dto.BattleRequestDTO;
import com.skyrim.rpg.application.dto.LogMessageDTO;
import com.skyrim.rpg.application.exceptions.BattleLogNotAvailableException;
import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.entities.Enemy;
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
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/battles", produces = {"application/json"})
@Tag(name = "rpg-api")
public class BattleController {

    private final GameContainer gameContainer;

    @Autowired
    public BattleController(GameContainer gameContainer) {
        this.gameContainer = gameContainer;
    }

    @Operation(summary = "Starts a new battle", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Battle successfully started"),
            @ApiResponse(responseCode = "400", description = "Character not found"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> startBattle(@RequestBody BattleRequestDTO battleRequest) {
        String characterId = battleRequest.getCharacterId();
        Character player = gameContainer.getCharacterService().findById(characterId);

        if (player == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Character not found with id: " + characterId));
        }

        gameContainer.getBattleService().startBattle(player);

        Enemy enemy = gameContainer.getEnemyFactory().createRandomEnemy();
        if (enemy == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "No enemy found for battle. Cannot proceed."));
        }

        Map<String, Object> battleData = Map.of("player", player, "enemy", enemy, "battleLog", gameContainer.getBattleService().getBattleLog());

        return ResponseEntity.status(HttpStatus.CREATED).body(battleData);
    }

    @Operation(summary = "Retrieves the current battle state", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Battle state retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Character not found"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @GetMapping("/{characterId}")
    public ResponseEntity<Map<String, Object>> getBattleState(@PathVariable String characterId) {
        Character player = gameContainer.getCharacterService().findById(characterId);
        if (player == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Character not found with id: " + characterId));
        }

        try {
            Map<String, Object> battleData = Map.of("player", player, "enemy", gameContainer.getEnemyFactory().createEnemy("ENEMY_DRAGON"), "battleLog", gameContainer.getBattleService().getBattleLog());

            return ResponseEntity.ok(battleData);
        } catch (NullPointerException e) {
            throw new BattleLogNotAvailableException("Failed to retrieve battle log", e);
        }
    }

    @Operation(summary = "Performs an action in the current battle", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Action performed successfully"),
            @ApiResponse(responseCode = "404", description = "Character not found"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @PostMapping("/{characterId}/action")
    public ResponseEntity<Map<String, Object>> handlePlayerActionChoice(@PathVariable String characterId, @RequestBody ActionRequestDTO actionRequest) {
        try {
            Character player = gameContainer.getCharacterService().findById(characterId);

            if (player == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Character not found with id: " + characterId));
            }

            gameContainer.getBattleService().performAction(actionRequest.getAction(), actionRequest.getSkillId());

            Map<String, Object> battleState = gameContainer.getBattleService().getBattleState();

            return ResponseEntity.ok().body(battleState);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
        }
    }

    @Operation(summary = "Logs a message for the current battle", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message logged successfully"),
            @ApiResponse(responseCode = "404", description = "Character not found"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @PostMapping("/{characterId}/logs")
    public ResponseEntity<Map<String, Object>> logMessage(@PathVariable String characterId, @RequestBody LogMessageDTO logMessageDTO) {
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

    @Operation(summary = "Retrieves battle logs for a character", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Battle logs retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Character not found"),
            @ApiResponse(responseCode = "204", description = "No battle logs found"),
            @ApiResponse(responseCode = "500", description = "System error")
    })
    @GetMapping("/{characterId}/logs")
    public ResponseEntity<List<String>> getBattleLogs(@PathVariable String characterId) {
        Character player = gameContainer.getCharacterService().findById(characterId);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<String> battleLog = gameContainer.getBattleService().getBattleLog();
        if (battleLog.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(battleLog);
    }
}
