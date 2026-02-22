package com.narxoz.rpg.combat;

public class ShadowAbility implements Ability{
    private final String name;
    private final int power;

    public ShadowAbility(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getPower() { return power; }

    @Override
    public String getDescription() {
        return "Shadow ability: " + name + " (Power: " + power + ")";
    }

    @Override
    public Ability clone() {
        return new ShadowAbility(name, power);
    }
}
