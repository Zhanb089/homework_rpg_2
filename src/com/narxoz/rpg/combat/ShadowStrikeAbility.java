package com.narxoz.rpg.combat;

public class ShadowStrikeAbility implements Ability{
    private final String name;
    private final int damage;
    private final String description;

    public ShadowStrikeAbility() {
        this.name = "Shadow Strike";
        this.damage = 40;
        this.description = "A fast strike from the shadows that deals critical damage.";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Ability clone() {
        return new ShadowStrikeAbility();
    }
}
