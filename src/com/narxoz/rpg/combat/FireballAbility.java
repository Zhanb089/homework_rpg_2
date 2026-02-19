package com.narxoz.rpg.combat;

public class FireballAbility implements Ability{
    private final String name;
    private final int damage;
    private final String description;

    public FireballAbility() {
        this.name = "Fireball";
        this.damage = 50;
        this.description = "Throws a powerful ball of fire at the enemy.";
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
        return new FireballAbility();
    }
}
