package com.skyrim.rpg.domain.factories;

import com.skyrim.rpg.domain.entities.Enemy;
import com.skyrim.rpg.domain.entities.Skill;
import com.skyrim.rpg.domain.enums.RoleEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class EnemyFactory {

    private static final RoleEnum[] ENEMY_TYPES = {
            RoleEnum.ENEMY_DRAGON,
            RoleEnum.ENEMY_GOBLIN,
            RoleEnum.ENEMY_SKELETON
    };

    private static final Random random = new Random();

    public Enemy createRandomEnemy() {
        RoleEnum randomEnemyType = ENEMY_TYPES[random.nextInt(ENEMY_TYPES.length)];
        return createEnemy(randomEnemyType);
    }

    public Enemy createEnemy(RoleEnum enemyType) {
        String name = enemyType.getRoleName();
        String description = enemyType.getDescription();
        int level = 1;
        int xpPoints = enemyType.getXpReward();

        List<Skill> skills = new ArrayList<>();

        return new Enemy(name, description, level, xpPoints, new ArrayList<>(), skills, enemyType);
    }
}
