package com.skyrim.rpg.domain.enums;

public enum StatusEnum {
    NORMAL("Normal"),
    ELITE("Elite"),
    BOSS("Boss");

    private final String statusName;

    StatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
