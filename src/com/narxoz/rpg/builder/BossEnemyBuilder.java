package com.narxoz.rpg.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.loot.LootTable;

public class BossEnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer, Integer> phases = new HashMap<>();
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public BossEnemyBuilder setName(String name) { this.name = name; return this; }
    public BossEnemyBuilder setHealth(int health) { this.health = health; return this; }
    public BossEnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    public BossEnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    public BossEnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    public BossEnemyBuilder setElement(String element) { this.element = element; return this; }
    public BossEnemyBuilder addAbility(Ability ability) { this.abilities.add(ability); return this; }
    public BossEnemyBuilder addPhase(int number, int threshold) { this.phases.put(number, threshold); return this; }
    public BossEnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }
    public BossEnemyBuilder setAI(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }
    public BossEnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; return this; }
    public BossEnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }
    public BossEnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities.clear();
        this.abilities.addAll(abilities);
        return this;
    }

    public DragonBoss build() {
        if (name == null || health <= 0) {
            throw new IllegalStateException("Boss must have name and health!");
        }

        return new DragonBoss(
                name, health, damage, defense, speed,
                element, abilities,
                phases.getOrDefault(1, 0),
                phases.getOrDefault(2, 0),
                phases.getOrDefault(3, 0),
                lootTable, aiBehavior, canFly, hasBreathAttack, wingspan
        );
    }
}
