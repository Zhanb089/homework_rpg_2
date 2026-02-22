package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Goblin implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.abilities = new ArrayList<>();
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void multiplyStats(double multiplier) {
        health = (int)(health * multiplier);
        damage = (int)(damage * multiplier);
        defense = (int)(defense * multiplier);
        speed = (int)(speed * multiplier);
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public List<Ability> getAbilities() { return abilities; }
    public Map<Integer, Integer> getPhases() { return new HashMap<>(); }
    public LootTable getLootTable() { return lootTable; }
    public String getAIBehavior() { return ""; }
    public boolean canFly() { return false; }
    public boolean hasBreathAttack() { return false; }
    public int getWingspan() { return 0; }

    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities: " + abilities.size());
    }

    public Enemy clone() {
        Goblin copy = new Goblin(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            copy.abilities.add(a.clone());
        }
        copy.lootTable = lootTable != null ? lootTable.clone() : null;
        return copy;
    }
    public Goblin(String name,
                  int health,
                  int damage,
                  List<Ability> abilities,
                  LootTable lootTable,
                  String aiBehavior) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = 0; // можно задать дефолт
        this.speed = 0;   // можно задать дефолт
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        this.lootTable = lootTable;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

}
