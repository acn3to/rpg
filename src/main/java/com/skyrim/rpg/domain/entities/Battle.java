package com.skyrim.rpg.domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a battle between a player character and an enemy.
 */
public class Battle {
    private Character player;
    private Enemy enemy;
    private List<String> battleLog;
    private int currentRound;
    private boolean playerTurn;
    private boolean battleEnded;

    /**
     * Constructs a Battle object with the given player and enemy.
     *
     * @param player The player character in the battle.
     * @param enemy  The enemy in the battle.
     */
    public Battle(Character player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.battleLog = new ArrayList<>();
        this.currentRound = 0;
        this.playerTurn = true;
        this.battleEnded = false;
    }

    /**
     * Retrieves the player character participating in the battle.
     *
     * @return The player character.
     */
    public Character getPlayer() {
        return player;
    }

    /**
     * Sets the player character participating in the battle.
     *
     * @param player The player character.
     */
    public void setPlayer(Character player) {
        this.player = player;
    }

    /**
     * Retrieves the enemy participating in the battle.
     *
     * @return The enemy.
     */
    public Enemy getEnemy() {
        return enemy;
    }

    /**
     * Sets the enemy participating in the battle.
     *
     * @param enemy The enemy.
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * Retrieves the battle log containing messages of the battle events.
     *
     * @return The battle log.
     */
    public List<String> getBattleLog() {
        return battleLog;
    }

    /**
     * Sets the battle log containing messages of the battle events.
     *
     * @param battleLog The battle log.
     */
    public void setBattleLog(List<String> battleLog) {
        this.battleLog = battleLog;
    }

    /**
     * Adds a message to the battle log.
     *
     * @param message The message to add.
     */
    public void addToBattleLog(String message) {
        this.battleLog.add(message);
    }

    /**
     * Retrieves the current round number of the battle.
     *
     * @return The current round number.
     */
    public int getCurrentRound() {
        return currentRound;
    }

    /**
     * Sets the current round number of the battle.
     *
     * @param currentRound The current round number.
     */
    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    /**
     * Checks if it's currently the player's turn in the battle.
     *
     * @return true if it's the player's turn, false otherwise.
     */
    public boolean isPlayerTurn() {
        return playerTurn;
    }

    /**
     * Sets whether it's currently the player's turn in the battle.
     *
     * @param playerTurn true if it's the player's turn, false otherwise.
     */
    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    /**
     * Checks if the battle has ended.
     *
     * @return true if the battle has ended, false otherwise.
     */
    public boolean isBattleEnded() {
        return battleEnded || getPlayer().getHealthPoints() <= 0 || getEnemy().getHealthPoints() <= 0;
    }

    /**
     * Sets whether the battle has ended.
     *
     * @param battleEnded true if the battle has ended, false otherwise.
     */
    public void setBattleEnded(boolean battleEnded) {
        this.battleEnded = battleEnded;
    }

    /**
     * Returns a string representation of the Battle object.
     *
     * @return A string representation of the Battle object.
     */
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
