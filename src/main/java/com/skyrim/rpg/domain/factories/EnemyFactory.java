package com.skyrim.rpg.domain.factories;

import com.skyrim.rpg.domain.entities.*;
import com.skyrim.rpg.domain.enums.EnemyEnum;
import com.skyrim.rpg.domain.interfaces.factories.EnemyFactoryInterface;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Factory class responsible for creating enemy entities based on specified types or randomly.
 */
@Component
public class EnemyFactory implements EnemyFactoryInterface {

    private static final EnemyEnum[] ENEMY_TYPES = EnemyEnum.values();
    private static final Random random = new Random();

    /**
     * Creates a random enemy based on the available enemy types.
     *
     * @return A randomly generated Enemy object.
     */
    public Enemy createRandomEnemy() {
        EnemyEnum randomEnemyType = ENEMY_TYPES[random.nextInt(ENEMY_TYPES.length)];
        return createEnemy(randomEnemyType);
    }

    /**
     * Creates an enemy of a specified type.
     *
     * @param enemyType The type of enemy to create.
     * @return An Enemy object of the specified type.
     */
    public Enemy createEnemy(EnemyEnum enemyType) {
        return switch (enemyType) {
            case DRAGON -> new Dragon(enemyType);
            case GOBLIN -> new Goblin(enemyType);
            case SKELETON -> new Skeleton(enemyType);
            case FROST_TROLL -> new FrostTroll(enemyType);
            case DRAUGR -> new Draugr(enemyType);
            case GIANT -> new Giant(enemyType);
            case ICE_WRAITH -> new IceWraith(enemyType);
        };
    }
}
