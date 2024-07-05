package com.skyrim.rpg.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    private Character player;
    private Enemy enemy;
    private List<String> battleLog;
    private int currentRound;
    private boolean playerTurn;
    private boolean battleEnded;

    public Battle(Character player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.battleLog = new ArrayList<>();
        this.currentRound = 0;
        this.playerTurn = true;
        this.battleEnded = false;
    }

    public Character getPlayer() {
        return player;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public List<String> getBattleLog() {
        return battleLog;
    }

    public void setBattleLog(List<String> battleLog) {
        this.battleLog = battleLog;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public boolean isBattleEnded() {
        return battleEnded || getPlayer().getHealthPoints() <= 0 || getEnemy().getHealthPoints() <= 0;
    }

    public void setBattleEnded(boolean battleEnded) {
        this.battleEnded = battleEnded;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "player=" + getPlayer() +
                ", enemy=" + getEnemy() +
                ", battleLog=" + getBattleLog() +
                ", currentRound=" + getCurrentRound() +
                ", playerTurn=" + isPlayerTurn() +
                '}';
    }
}
