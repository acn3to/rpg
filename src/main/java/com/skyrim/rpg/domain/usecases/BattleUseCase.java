package com.skyrim.rpg.domain.usecases;

import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.entities.Enemy;
import com.skyrim.rpg.domain.entities.Battle;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.factories.EnemyFactory;
import com.skyrim.rpg.domain.interfaces.usecases.BattleUseCaseInterface;
import com.skyrim.rpg.utils.BattleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class BattleUseCase implements BattleUseCaseInterface {

    private final EnemyFactory enemyFactory;
    private Battle battle;

    @Autowired
    public BattleUseCase(EnemyFactory enemyFactory) {
        this.enemyFactory = enemyFactory;
    }

    public void startBattle(Character player) {
        Enemy enemy = enemyFactory.createRandomEnemy();
        battle = new Battle(player, enemy);
        logMessage("Battle started against " + enemy.getName());
        startRound();
    }

    public Map<String, Object> getBattleStateMap() {
        return Map.of(
                "player", battle.getPlayer(),
                "enemy", battle.getEnemy(),
                "battleLog", new ArrayList<>(battle.getBattleLog()),
                "playerTurn", battle.isPlayerTurn(),
                "currentRound", battle.getCurrentRound()
        );
    }

    public void performAction(String action, String skillId) {
        StringBuilder actionLog = new StringBuilder();

        if (battle.isPlayerTurn()) {
            switch (action.toLowerCase()) {
                case "attack":
                    attack();
                    break;
                case "defend":
                    defend();
                    break;
                case "flee":
                    actionLog.append(battle.getPlayer().getName()).append(" attempts to flee from battle. ");
                    flee(actionLog);
                    break;
                case "use-skill":
                    useSkill(skillId);
                    break;
                default:
                    actionLog.append("Invalid action: ").append(action);
                    break;
            }

            actionLog.append(logBattleState());
            logMessage(actionLog.toString());

            handleBattleEnd();

            if (!isBattleEnded() && battle.isPlayerTurn()) {
                startEnemyTurn();
            }
        } else {
            logMessage("It's not your turn. Enemy is attacking.");
        }
    }

    private void attack() {
        int damage = battle.getPlayer().calculateAttackDamage();
        if (isCriticalHit(battle.getPlayer())) {
            damage = BattleUtils.calculateCriticalDamage(damage);
            logMessage("Critical hit! " + battle.getPlayer().getName() + " deals " + damage + " damage to " + battle.getEnemy().getName());
        } else {
            logMessage(battle.getPlayer().getName() + " attacks " + battle.getEnemy().getName() + " and deals " + damage + " damage.");
        }
        BattleUtils.applyDamage(battle.getEnemy(), damage);
    }

    private void enemyAttack() {
        if (Math.random() <= 0.5) {
            useRandomEnemySkill();
        } else {
            performNormalEnemyAttack();
        }
    }

    private void useRandomEnemySkill() {
        Skill skill = getRandomEnemySkill();

        if (skill == null) {
            performNormalEnemyAttack();
            return;
        }

        int skillDamage = battle.getEnemy().calculateSkillDamage(skill);

        switch (skill.getName()) {
            case "Claw Swipe":
            case "Fireball":
            case "Ice Bolt":
                if (isCriticalHit(battle.getEnemy())) {
                    skillDamage = BattleUtils.calculateCriticalDamage(skillDamage);
                    logMessage("Critical hit! " + battle.getEnemy().getName() + " uses " + skill.getName() + " dealing " + skillDamage + " damage to " + battle.getPlayer().getName());
                } else {
                    logMessage(battle.getEnemy().getName() + " uses " + skill.getName() + " dealing " + skillDamage + " damage to " + battle.getPlayer().getName());
                }
                BattleUtils.applyDamage(battle.getPlayer(), skillDamage);
                break;
            default:
                logMessage("Enemy uses " + skill.getName() + ". Skill effect not implemented.");
                break;
        }
    }

    private Skill getRandomEnemySkill() {
        List<Skill> enemySkills = battle.getEnemy().getSkills();
        if (enemySkills.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * enemySkills.size());
        return enemySkills.get(randomIndex);
    }

    private void performNormalEnemyAttack() {
        int damage = BattleUtils.calculateEnemyAttackDamage(battle.getEnemy());
        if (isCriticalHit(battle.getEnemy())) {
            damage = BattleUtils.calculateCriticalDamage(damage);
            logMessage("Enemy lands a critical hit! " + battle.getEnemy().getName() + " deals " + damage + " damage to " + battle.getPlayer().getName());
        } else {
            logMessage(battle.getEnemy().getName() + " attacks " + battle.getPlayer().getName() + " and deals " + damage + " damage.");
        }
        BattleUtils.applyDamage(battle.getPlayer(), damage);
    }

    private boolean isCriticalHit(Character character) {
        double criticalChance = character.calculateCriticalChance() / 100.0;
        return Math.random() <= criticalChance;
    }

    private void useSkill(String skillId) {
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
                if (isCriticalHit(battle.getPlayer())) {
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
    }

    private Skill findSkillById(String skillId) {
        for (Skill skill : battle.getPlayer().getSkills()) {
            if (skill.getId().equals(skillId)) {
                return skill;
            }
        }
        return null;
    }

    private void defend() {
        int defenseBonus = 5;
        battle.getPlayer().setDefensePoints(battle.getPlayer().getDefensePoints() + defenseBonus);
        logMessage(battle.getPlayer().getName() + " increases defense by " + defenseBonus + " points.");
    }

    private void flee(StringBuilder actionLog) {
        boolean isDodged = BattleUtils.calculateDodged(battle.getPlayer().getAgilityPoints(), battle.getEnemy().getAgilityPoints());
        if (isDodged) {
            actionLog.append("Successfully fled the battle.");
            battle.setBattleEnded(true);
        } else {
            actionLog.append("Failed to flee.");
        }
        logMessage(actionLog.toString());
    }

    private void startRound() {
        battle.setPlayerTurn(true);
        battle.setCurrentRound(battle.getCurrentRound() + 1);
        logMessage("Round " + battle.getCurrentRound() + " started.");
    }

    private void startEnemyTurn() {
        battle.setPlayerTurn(false);
        enemyAttack();
        handleBattleEnd();
        if (!isBattleEnded()) {
            startRound();
        }
    }

    private boolean isBattleEnded() {
        return battle.getPlayer().getHealthPoints() <= 0 || battle.getEnemy().getHealthPoints() <= 0 || battle.isBattleEnded();
    }

    private void handleBattleEnd() {
        if (isBattleEnded()) {
            if (battle.getPlayer().getHealthPoints() <= 0) {
                logMessage(battle.getPlayer().getName() + " was defeated.");
            } else {
                int xpReward = battle.getEnemy().getXpReward();
                battle.getPlayer().setXpPoints(battle.getPlayer().getXpPoints() + xpReward);
                logMessage(battle.getPlayer().getName() + " earned " + xpReward + " XP from defeating " + battle.getEnemy().getName() + ".");

                if (checkForLevelUp()) {
                    levelUpPlayer();
                    logMessage("Congratulations! " + battle.getPlayer().getName() + " leveled up to level " + battle.getPlayer().getLevel() + "!");
                }

                logMessage(battle.getPlayer().getName() + " won the battle against " + battle.getEnemy().getName() + ".");
            }

            logMessage("Battle ended.");
        }
    }

    private boolean checkForLevelUp() {
        int currentXP = battle.getPlayer().getXpPoints();
        int requiredXP = calculateRequiredXPForNextLevel(battle.getPlayer().getLevel());
        return currentXP >= requiredXP;
    }

    private int calculateRequiredXPForNextLevel(int currentLevel) {
        return currentLevel * 100;
    }

    private void levelUpPlayer() {
        Character player = battle.getPlayer();
        int currentLevel = player.getLevel();
        player.setLevel(currentLevel + 1);

        player.setHealthPoints(player.getHealthPoints() + 10);
        player.setManaPoints(player.getManaPoints() + 5);

        logMessage(player.getName() + " leveled up to level " + player.getLevel() + ". New attributes: HP - " + player.getHealthPoints() + ", MP - " + player.getManaPoints());

        int currentXP = player.getXpPoints();
        int requiredXP = calculateRequiredXPForNextLevel(player.getLevel());
        player.setXpPoints(currentXP - requiredXP);
    }

    private String logBattleState() {
        return "Current HP - Player: " + battle.getPlayer().getHealthPoints() + ", Enemy: " + battle.getEnemy().getHealthPoints();
    }

    public void logMessage(String message) {
        battle.getBattleLog().add(message);
    }

    public List<String> getBattleLog() {
        return new ArrayList<>(battle.getBattleLog());
    }
}
