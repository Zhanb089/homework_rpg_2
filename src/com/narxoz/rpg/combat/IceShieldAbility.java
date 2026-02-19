package com.narxoz.rpg.combat;

public class IceShieldAbility implements Ability{
    private final String name;
    private final int damage;
    private final String description;

    public IceShieldAbility() {
        this.name = "Ice Shield";
        this.damage = 0; // защита, не атакует
        this.description = "Creates a protective shield of ice that absorbs damage.";
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
        return new IceShieldAbility();
    }
    
}
