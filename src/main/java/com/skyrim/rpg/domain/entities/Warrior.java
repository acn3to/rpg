package com.skyrim.rpg.domain.entities;

public class Warrior {
    private int ragePoints;

    public Warrior(int ragePoints) {
        this.ragePoints = ragePoints;
    }

    public int getRagePoints() {
        return ragePoints;
    }

    public void setRagePoints(int ragePoints) {
        this.ragePoints = ragePoints;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "ragePoints=" + getRagePoints() +
                '}';
    }
}
