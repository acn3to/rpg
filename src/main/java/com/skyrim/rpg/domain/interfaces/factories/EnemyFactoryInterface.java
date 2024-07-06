package com.skyrim.rpg.domain.interfaces.factories;

import com.skyrim.rpg.domain.entities.Enemy;

public interface EnemyFactoryInterface {
    Enemy createEnemy(String enemyType);
    Enemy createRandomEnemy();
}
