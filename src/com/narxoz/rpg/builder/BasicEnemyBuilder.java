package com.narxoz.rpg.builder;

import java.util.ArrayList;
import java.util.List;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

public class BasicEnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private String aiBehavior;

    public BasicEnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BasicEnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public BasicEnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public BasicEnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    public BasicEnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    public BasicEnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    public Enemy build() {
        return new Goblin(
                name,
                health,
                damage,
                abilities,
                lootTable,
                aiBehavior
        );
    }
}
