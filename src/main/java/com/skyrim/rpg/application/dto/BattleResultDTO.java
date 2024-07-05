package com.skyrim.rpg.application.dto;

import com.skyrim.rpg.domain.entities.Character;

import java.util.List;

public class BattleResultDTO {
    private String battleState;
    private List<String> battleLog;
    private Character player;
    private Character enemy;

    public String getBattleState() {
        return battleState;
    }

    public void setBattleState(String battleState) {
        this.battleState = battleState;
    }

    public List<String> getBattleLog() {
        return battleLog;
    }

    public void setBattleLog(List<String> battleLog) {
        this.battleLog = battleLog;
    }

    public Character getPlayer() {
        return player;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }

    public Character getEnemy() {
        return enemy;
    }

    public void setEnemy(Character enemy) {
        this.enemy = enemy;
    }
}
