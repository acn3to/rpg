package com.skyrim.rpg.domain.services;

import com.skyrim.rpg.domain.entities.Character;
import com.skyrim.rpg.domain.interfaces.services.BattleServiceInterface;
import com.skyrim.rpg.domain.usecases.BattleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BattleService implements BattleServiceInterface {

    private final BattleUseCase battleUseCase;

    @Autowired
    public BattleService(BattleUseCase battleUseCase) {
        this.battleUseCase = battleUseCase;
    }

    public void startBattle(Character player) {
        battleUseCase.startBattle(player);
    }

    public Map<String, Object> getBattleState() {
        return battleUseCase.getBattleStateMap();
    }

    public void performAction(String action, String skillId) {
        battleUseCase.performAction(action, skillId);
    }

    public List<String> getBattleLog() {
        return battleUseCase.getBattleLog();
    }

    public void logMessage(String message) {
        battleUseCase.logMessage(message);
    }
}
