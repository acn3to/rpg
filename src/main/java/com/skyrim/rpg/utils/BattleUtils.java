package com.skyrim.rpg.utils;

import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.entities.Enemy;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BattleUtils {

    private static final Random random = new Random();

    public static void applyDamage(Character character, int damage) {
        int currentHP = character.getHealthPoints();
        int remainingHP = Math.max(currentHP - damage, 0);
        character.setHealthPoints(remainingHP);
    }

    public static int calculateEnemyAttackDamage(Enemy enemy) {
        return enemy.calculateAttackDamage();
    }

    public static int calculateCriticalDamage(int damage) {
        double multiplier = 1.5;
        return (int) (damage * multiplier);
    }

    public static boolean calculateDodged(int playerAgility, int enemyAgility) {
        double dodgeChance = 0.1 + (playerAgility - enemyAgility) / 100.0;
        return random.nextDouble() <= dodgeChance;
    }
}
