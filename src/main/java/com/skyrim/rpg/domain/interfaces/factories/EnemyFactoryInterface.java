package com.skyrim.rpg.domain.interfaces.factories;

import com.skyrim.rpg.domain.entities.Enemy;
import com.skyrim.rpg.domain.enums.EnemyEnum;

public interface EnemyFactoryInterface {
    Enemy createEnemy(EnemyEnum enemyType);
    Enemy createRandomEnemy();
}
