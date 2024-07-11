package com.skyrim.rpg.utils;

import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.entities.Enemy;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Utility class for handling battle-related operations such as applying damage,
 * calculating attack damage, critical hits, and dodge chances.
 */
@Component
public class BattleUtils {

    private static final Random random = new Random();

    /**
     * Applies damage to a character or enemy entity.
     *
     * @param entity The character or enemy entity to apply damage to.
     * @param damage The amount of damage to apply.
     * @throws IllegalArgumentException If the entity type is not supported.
     */
    public static void applyDamage(Object entity, int damage) {
        if (entity instanceof Character) {
            applyDamage((Character) entity, damage);
        } else if (entity instanceof Enemy) {
            applyDamage((Enemy) entity, damage);
        } else {
            throw new IllegalArgumentException("Unsupported entity type: " + entity.getClass().getName());
        }
    }

    /**
     * Applies damage to a character.
     *
     * @param character The character entity to apply damage to.
     * @param damage    The amount of damage to apply.
     */
    private static void applyDamage(Character character, int damage) {
        int currentHP = character.getHealthPoints();
        int remainingHP = Math.max(currentHP - damage, 0);
        character.setHealthPoints(remainingHP);
    }

    /**
     * Applies damage to an enemy.
     *
     * @param enemy  The enemy entity to apply damage to.
     * @param damage The amount of damage to apply.
     */
    private static void applyDamage(Enemy enemy, int damage) {
        int currentHP = enemy.getHealthPoints();
        int remainingHP = Math.max(currentHP - damage, 0);
        enemy.setHealthPoints(remainingHP);
    }

    /**
     * Calculates the attack damage for an enemy.
     *
     * @param enemy The enemy entity for which to calculate attack damage.
     * @return The calculated attack damage.
     */
    public static int calculateEnemyAttackDamage(Enemy enemy) {
        return enemy.calculateAttackDamage();
    }

    /**
     * Calculates the attack damage for a character.
     *
     * @param character The character entity for which to calculate attack damage.
     * @return The calculated attack damage.
     */
    public static int calculateAttackDamage(Character character) {
        return character.calculateAttackDamage();
    }

    /**
     * Calculates critical damage based on a base damage.
     *
     * @param damage The base damage to apply critical hit to.
     * @return The calculated critical damage.
     */
    public static int calculateCriticalDamage(int damage) {
        double multiplier = 1.5;
        return (int) (damage * multiplier);
    }

    /**
     * Calculates dodge chance based on player and enemy agility.
     *
     * @param playerAgility The agility of the player character.
     * @param enemyAgility  The agility of the enemy character.
     * @return True if the dodge was successful, false otherwise.
     */
    public static boolean calculateDodged(int playerAgility, int enemyAgility) {
        double dodgeChance = 0.1 + (playerAgility - enemyAgility) / 100.0;
        return random.nextDouble() <= dodgeChance;
    }

    /**
     * Determines if a character lands a critical hit based on its critical chance.
     *
     * @param character The character entity to determine critical hit for.
     * @return True if the character lands a critical hit, false otherwise.
     */
    public static boolean isCriticalHit(Character character) {
        double criticalChance = character.calculateCriticalChance() / 100.0;
        return random.nextDouble() <= criticalChance;
    }

    /**
     * Determines if an enemy lands a critical hit based on its critical chance.
     *
     * @param enemy The enemy entity to determine critical hit for.
     * @return True if the enemy lands a critical hit, false otherwise.
     */
    public static boolean isCriticalHit(Enemy enemy) {
        double criticalChance = enemy.calculateCriticalChance() / 100.0;
        return random.nextDouble() <= criticalChance;
    }
}
