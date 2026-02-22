package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        FireComponentFactory fireFactory = new FireComponentFactory();
        IceComponentFactory iceFactory = new IceComponentFactory();
        ShadowComponentFactory shadowFactory = new ShadowComponentFactory();

        List<Ability> fireAbilities = fireFactory.createAbilities();
        LootTable fireLoot = fireFactory.createLootTable();
        List<Ability> iceAbilities = iceFactory.createAbilities();
        LootTable iceLoot = iceFactory.createLootTable();
        List<Ability> shadowAbilities = shadowFactory.createAbilities();
        LootTable shadowLoot = shadowFactory.createLootTable();

        System.out.println("=== PART 2: Builder Pattern ===\n");

        Enemy dragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .addAbility(fireAbilities.get(0))
                .addAbility(fireAbilities.get(1))
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .setLootTable(fireLoot)
                .setAI("Aggressive")
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(20)
                .build();

        Enemy goblin = new BasicEnemyBuilder()
                .setName("Forest Goblin")
                .setHealth(2000)
                .setDamage(50)
                .addAbility(iceAbilities.get(0))
                .setLootTable(iceLoot)
                .setAI("Cautious")
                .build();

        dragon.displayInfo();
        goblin.displayInfo();

        System.out.println("\n=== PART 3: Prototype Pattern ===\n");

        Enemy dragonClone = dragon.clone();
        dragonClone.setName("Fire Dragon Elite");
        dragonClone.multiplyStats(2.0);

        Enemy goblinClone = goblin.clone();
        goblinClone.setName("Goblin Raider");
        goblinClone.multiplyStats(1.5);

        dragonClone.displayInfo();
        goblinClone.displayInfo();

        System.out.println("\n=== PART 4: Full Pipeline ===\n");

        Enemy shadowDemon = new BossEnemyBuilder()
                .setName("Demon Lord")
                .addAbility(shadowAbilities.get(0))
                .addAbility(shadowAbilities.get(1))
                .setLootTable(shadowLoot)
                .setAI("Cunning")
                .setHealth(40000)
                .setDamage(400)
                .addPhase(1, 40000)
                .addPhase(2, 25000)
                .addPhase(3, 10000)
                .setCanFly(true)
                .setHasBreathAttack(false)
                .setWingspan(15)
                .build();

        Enemy shadowDemonClone = shadowDemon.clone();
        shadowDemonClone.setName("Greater Demon");
        shadowDemonClone.multiplyStats(2.0);

        shadowDemon.displayInfo();
        shadowDemonClone.displayInfo();

        System.out.println("\n=== Pattern Summary ===\n");
        System.out.println("Abstract Factory: Created themed component families (Fire, Ice, Shadow)");
        System.out.println("Builder: Step-by-step enemy construction (Boss & Basic enemies)");
        System.out.println("Factory Method: build() embedded in Builder");
        System.out.println("Prototype: Deep copy clones with modified stats");

        System.out.println("\n=== Demo Complete ===");
    }

    
}
