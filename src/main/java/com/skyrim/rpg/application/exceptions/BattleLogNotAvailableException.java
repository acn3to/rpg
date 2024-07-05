package com.skyrim.rpg.application.exceptions;

public class BattleLogNotAvailableException extends RuntimeException {

    public BattleLogNotAvailableException(String message) {
        super(message);
    }

    public BattleLogNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
