package com.skyrim.rpg.domain.interfaces.usecases;
import com.skyrim.rpg.domain.entities.Character;

import java.util.List;
import java.util.Map;

public interface BattleUseCaseInterface {
    void startBattle(Character player);
    void performAction(String action, String skillId);
    Map<String, Object> getBattleStateMap();
    List<String> getBattleLog();
}