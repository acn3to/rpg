package com.skyrim.rpg.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {
    private int id;
    private Player player;
    private Enemy enemy;
    private List<String> battleLog;
    private boolean playerTurn;

    public Battle(int id, Player player, Enemy enemy) {
        this.id = id;
        this.player = player;
        this.enemy = enemy;
        this.battleLog = new ArrayList<>();
        this.playerTurn = new Random().nextBoolean();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
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

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void logAction(String action) {
        battleLog.add(action);
    }

    public void startBattle() {
        logAction("Battle started between " + player.getName() + " and " + enemy.getName());
    }

    public void nextTurn() {
        playerTurn = !playerTurn;
        logAction(playerTurn ? "Player's turn" : "Enemy's turn");
    }

    @Override
    public String toString() {
        return "Battle{" +
                "id=" + getId() +
                ", player=" + getPlayer() +
                ", enemy=" + getEnemy() +
                ", battleLog=" + getBattleLog() +
                ", playerTurn=" + isPlayerTurn() +
                '}';
    }
}
