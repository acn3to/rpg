package com.skyrim.rpg.domain.interfaces.services;

import com.skyrim.rpg.domain.entities.Battle;

import java.util.Map;

public interface BattleServiceInterface {
    public interface BattleService {
        void startBattle(Battle battle);
        void performAction(Battle battle, String action, String skillId);
        Map<String, Object> getBattleState(Battle battle);
        void endBattle(Battle battle);
    }
}