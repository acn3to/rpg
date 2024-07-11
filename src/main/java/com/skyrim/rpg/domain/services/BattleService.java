package com.skyrim.rpg.domain.services;

import com.skyrim.rpg.domain.entities.*;
import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.interfaces.services.BattleServiceInterface;
import com.skyrim.rpg.utils.BattleUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service class responsible for managing battle-related operations between a player character and an enemy.
 */
@Service
public class BattleService implements BattleServiceInterface {
    private Battle battle;


    /**
     * Starts a battle between a player character and an enemy.
     *
     * @param player The player character participating in the battle.
     * @param enemy  The enemy participating in the battle.
     */
    public void startBattle(Character player, Enemy enemy) {
        logMessage("Starting battle for player: " + player.getName());
        battle = new Battle(player, enemy);
        logMessage("Battle started against " + enemy.getName());
        startRound();
    }

    /**
     * Retrieves the current state of the battle.
     *
     * @return A map containing the player, enemy, battle log, player turn status, and current round.
     */
    public Map<String, Object> getBattleStateMap() {
        if (battle == null) {
            return Map.of();
        }
        return Map.of(
                "player", battle.getPlayer(),
                "enemy", battle.getEnemy(),
                "battleLog", new ArrayList<>(battle.getBattleLog()),
                "playerTurn", battle.isPlayerTurn(),
                "currentRound", battle.getCurrentRound()
        );
    }

    /**
     * Performs an action during the player's turn in battle.
     *
     * @param action   The action to perform (e.g., attack, defend, flee, use-skill).
     * @param skillId  The ID of the skill to use, if applicable.
     */
    public void performAction(String action, String skillId) {
        if (battle == null || isBattleEnded()) {
            logMessage("Battle is not active or has ended. No action can be performed.");
            return;
        }

        if (battle.isPlayerTurn()) {
            switch (action.toLowerCase()) {
                case "attack":
                    attack();
                    break;
                case "defend":
                    defend();
                    break;
                case "flee":
                    flee();
                    break;
                case "use-skill":
                    useSkill(skillId);
                    break;
                default:
                    logMessage("Invalid action: " + action);
                    break;
            }

            if (!isBattleEnded() && battle.isPlayerTurn()) {
                startEnemyTurn();
            }
        } else {
            logMessage("It's not your turn. Enemy is attacking.");
        }
    }

    /**
     * Performs a basic attack action by the player.
     */
    public void attack() {
        logMessage("Performing player attack");
        int damage = BattleUtils.calculateAttackDamage(battle.getPlayer());
        if (BattleUtils.isCriticalHit(battle.getPlayer())) {
            damage = BattleUtils.calculateCriticalDamage(damage);
            logMessage("Critical hit! " + battle.getPlayer().getName() + " deals " + damage + " damage to " + battle.getEnemy().getName());
        } else {
            logMessage(battle.getPlayer().getName() + " attacks " + battle.getEnemy().getName() + " and deals " + damage + " damage.");
        }
        BattleUtils.applyDamage(battle.getEnemy(), damage);

        handleBattleEnd();
    }

    /**
     * Executes an enemy's turn, deciding between a normal attack or a random skill usage.
     */
    public void enemyAttack() {
        logMessage("Enemy attacks");
        if (Math.random() <= 0.3) {
            useRandomEnemySkill();
        } else {
            performNormalEnemyAttack();
        }

        handleBattleEnd();
    }

    /**
     * Performs a normal enemy attack during the enemy's turn.
     */
    public void performNormalEnemyAttack() {
        logMessage("Performing enemy normal attack");
        int damage = BattleUtils.calculateEnemyAttackDamage(battle.getEnemy());
        if (BattleUtils.isCriticalHit(battle.getEnemy())) {
            damage = BattleUtils.calculateCriticalDamage(damage);
            logMessage("Enemy lands a critical hit! " + battle.getEnemy().getName() + " deals " + damage + " damage to " + battle.getPlayer().getName());
        } else {
            logMessage(battle.getEnemy().getName() + " attacks " + battle.getPlayer().getName() + " and deals " + damage + " damage.");
        }
        BattleUtils.applyDamage(battle.getPlayer(), damage);
    }

    /**
     * Uses a random skill from the enemy's skill set during their turn.
     */
    public void useRandomEnemySkill() {
        logMessage("Using random enemy skill");
        Skill skill = getRandomEnemySkill();

        if (skill == null) {
            performNormalEnemyAttack();
            return;
        }

        int skillDamage = battle.getEnemy().calculateSkillDamage(skill);

        boolean skillFound = false;
        for (Skill enemySkill : battle.getEnemy().getSkills()) {
            if (enemySkill.getName().equals(skill.getName())) {
                skillFound = true;
                if (BattleUtils.isCriticalHit(battle.getEnemy())) {
                    skillDamage = BattleUtils.calculateCriticalDamage(skillDamage);
                    logMessage("Critical hit! " + battle.getEnemy().getName() + " uses " + skill.getName() + " dealing " + skillDamage + " damage to " + battle.getPlayer().getName());
                } else {
                    logMessage(battle.getEnemy().getName() + " uses " + skill.getName() + " dealing " + skillDamage + " damage to " + battle.getPlayer().getName());
                }
                BattleUtils.applyDamage(battle.getPlayer(), skillDamage);
                break;
            }
        }

        if (!skillFound) {
            logMessage("Enemy uses " + skill.getName() + ". Skill effect not implemented.");
        }
    }

    /**
     * Retrieves a random skill from the enemy's skill set.
     *
     * @return A random Skill object from the enemy's skills.
     */
    public Skill getRandomEnemySkill() {
        List<Skill> enemySkills = battle.getEnemy().getSkills();
        if (enemySkills.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * enemySkills.size());
        return enemySkills.get(randomIndex);
    }

    /**
     * Uses a specific skill identified by its ID during the player's turn.
     *
     * @param skillId The ID of the skill to use.
     */
    public void useSkill(String skillId) {
        logMessage("Using player skill with id: " + skillId);
        Skill skill = findSkillById(skillId);

        if (skill == null) {
            logMessage("Skill with id " + skillId + " not found.");
            return;
        }

        int skillDamage = battle.getPlayer().calculateSkillDamage(skill);

        switch (skill.getName()) {
            case "Slash":
            case "Arrow Shot":
            case "Club Smash":
            case "Bone Rattle":
            case "Back-stab":
                if (BattleUtils.isCriticalHit(battle.getPlayer())) {
                    skillDamage = BattleUtils.calculateCriticalDamage(skillDamage);
                    logMessage(skill.getName() + " is a critical hit! " + battle.getPlayer().getName() + " deals " + skillDamage + " damage to " + battle.getEnemy().getName());
                } else {
                    logMessage(battle.getPlayer().getName() + " used " + skill.getName() + " dealing " + skillDamage + " damage to " + battle.getEnemy().getName());
                }
                BattleUtils.applyDamage(battle.getEnemy(), skillDamage);
                break;
            case "Fireball":
            case "Fire Breath":
                logMessage(battle.getPlayer().getName() + " used " + skill.getName() + " dealing " + skillDamage + " damage to " + battle.getEnemy().getName());
                BattleUtils.applyDamage(battle.getEnemy(), skillDamage);
                break;
            default:
                logMessage("Skill " + skill.getName() + " is not implemented.");
                break;
        }

        handleBattleEnd();
    }

    /**
     * Finds a skill by its ID from the player's skill set.
     *
     * @param skillId The ID of the skill to find.
     * @return The Skill object if found, otherwise null.
     */
    public Skill findSkillById(String skillId) {
        for (Skill skill : battle.getPlayer().getSkills()) {
            if (skill.getId().equals(skillId)) {
                return skill;
            }
        }
        return null;
    }

    /**
     * Increases the player's defense points temporarily during their turn.
     */
    public void defend() {
        logMessage("Player defends");
        int defenseBonus = 5;
        battle.getPlayer().setDefensePoints(battle.getPlayer().getDefensePoints() + defenseBonus);
        logMessage(battle.getPlayer().getName() + " increases defense by " + defenseBonus + " points.");

        handleBattleEnd();
    }

    /**
     * Allows the player to attempt to flee from battle, with a chance of success based on agility.
     */
    public void flee() {
        logMessage("Player attempts to flee");
        String message = battle.getPlayer().getName() + " attempts to flee from battle. ";
        boolean isDodged = BattleUtils.calculateDodged(battle.getPlayer().getAgilityPoints(), battle.getEnemy().getAgility());
        if (isDodged) {
            message += "Successfully fled the battle.";
            battle.setBattleEnded(true);
        } else {
            message += "Failed to flee.";
        }
        logMessage(message);

        handleBattleEnd();
    }

    /**
     * Starts the next round of the battle, resetting turn-based actions.
     */
    public void startRound() {
        Character player = battle.getPlayer();
        Enemy enemy = battle.getEnemy();
        int currentRound = battle.getCurrentRound() + 1;

        battle.setCurrentRound(currentRound);
        battle.setPlayerTurn(true);

        logMessage("Round " + currentRound + " started.");
        logMessage(player.getName() + " HP: " + player.getHealthPoints() + "/" + player.getMaxHealthPoints());
        logMessage(enemy.getName() + " HP: " + enemy.getHealthPoints() + "/" + enemy.getMaxHealthPoints());
    }

    /**
     * Starts the enemy's turn in battle.
     */
    public void startEnemyTurn() {
        logMessage("Enemy turn starts.");
        battle.setPlayerTurn(false);
        enemyAttack();
        battle.setPlayerTurn(true);
        logMessage("Player turn starts.");
        if (!isBattleEnded()) {
            startRound();
        }
    }

    /**
     * Handles the end of the battle, checking for victory, defeat, or continuation.
     */
    public void handleBattleEnd() {
        if (isBattleEnded()) {
            logMessage("Battle ended.");

            if (battle.getPlayer().getHealthPoints() <= 0) {
                handlePlayerDefeat();
            } else if (battle.getEnemy().getHealthPoints() <= 0) {
                handlePlayerVictory();
            }

            battle.setBattleEnded(true);
            battle.setPlayerTurn(false);
        }
    }

    /**
     * Handles actions to be taken when the player wins the battle.
     */
    private void handlePlayerVictory() {
        Character player = battle.getPlayer();
        int experiencePoints = battle.getEnemy().getXpRewards();
        player.setXpPoints(experiencePoints);
        logMessage(player.getName() + " wins the battle!");
        logMessage(player.getName() + " gains " + experiencePoints + " experience points.");
    }

    private void handlePlayerDefeat() {
        logMessage("Player is defeated.");
    }

    /**
     * Checks if the battle has ended.
     *
     * @return true if the battle has ended, false otherwise.
     */
    private boolean isBattleEnded() {
        if (battle == null) {
            return true;
        }

        Character player = battle.getPlayer();
        Enemy enemy = battle.getEnemy();

        return player.getHealthPoints() <= 0 || enemy.getHealthPoints() <= 0;
    }

    /**
     * Logs a message related to battle actions.
     *
     * @param message The message to log.
     */
    public void logMessage(String message) {
        if (battle != null) {
            battle.addToBattleLog(message);
        }
    }

    /**
     * Retrieves the battle log.
     *
     * @return The battle log as a list of strings.
     */
    public List<String> getBattleLog() {
        if (battle == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(battle.getBattleLog());
    }
}
