package com.narxoz.rpg.combat;

public class FireAbility implements Ability{
    private final String name;
    private final int power;

    public FireAbility(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getPower() { return power; }

    @Override
    public String getDescription() {
        return "Fire ability: " + name + " (Power: " + power + ")";
    }

    @Override
    public Ability clone() {
        return new FireAbility(name, power);
    }
}
