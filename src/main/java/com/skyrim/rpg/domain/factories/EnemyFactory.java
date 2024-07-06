package com.skyrim.rpg.domain.factories;

import com.skyrim.rpg.domain.entities.Enemy;
import com.skyrim.rpg.domain.entities.Skill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class EnemyFactory {

    private static final String[] ENEMY_TYPES = {
            "Dragon",
            "Goblin",
            "Skeleton"
    };

    private static final Random random = new Random();

    public Enemy createRandomEnemy() {
        String randomEnemyType = ENEMY_TYPES[random.nextInt(ENEMY_TYPES.length)];
        return createEnemy(randomEnemyType);
    }

    public Enemy createEnemy(String enemyType) {
        String name = getName(enemyType);
        String description = getDescription(enemyType);
        int level = 1;
        int xpPoints = getXpReward(enemyType);

        List<Skill> skills = new ArrayList<>();

        return new Enemy(name, description, level, xpPoints, new ArrayList<>(), skills, enemyType, xpPoints);
    }

    private String getName(String enemyType) {
        switch (enemyType) {
            case "Dragon":
                return "Dragon";
            case "Goblin":
                return "Goblin";
            case "Skeleton":
                return "Skeleton";
            default:
                throw new IllegalArgumentException("Unknown enemy type: " + enemyType);
        }
    }

    private String getDescription(String enemyType) {
        switch (enemyType) {
            case "Dragon":
                return "A fearsome dragon with fiery breath.";
            case "Goblin":
                return "A mischievous goblin that likes to cause trouble.";
            case "Skeleton":
                return "A reanimated skeleton with a thirst for revenge.";
            default:
                throw new IllegalArgumentException("Unknown enemy type: " + enemyType);
        }
    }

    private int getXpReward(String enemyType) {
        switch (enemyType) {
            case "Dragon":
                return 500;
            case "Goblin":
                return 100;
            case "Skeleton":
                return 200;
            default:
                throw new IllegalArgumentException("Unknown enemy type: " + enemyType);
        }
    }

}
