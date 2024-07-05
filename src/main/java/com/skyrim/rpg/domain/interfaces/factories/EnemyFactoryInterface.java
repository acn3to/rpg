package com.skyrim.rpg.domain.interfaces.factories;

import com.skyrim.rpg.domain.entities.Enemy;
import com.skyrim.rpg.domain.enums.RoleEnum;

public interface EnemyFactoryInterface {
    Enemy createEnemy(RoleEnum enemyType);
    Enemy createRandomEnemy();
}
