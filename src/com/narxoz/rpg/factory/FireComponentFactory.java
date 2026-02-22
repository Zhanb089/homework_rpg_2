package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FireAbility;
import com.narxoz.rpg.loot.FireLootTable;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory{
    
    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new FireAbility("Flame Burst", 120),
                new FireAbility("Inferno", 200)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new FireLootTable();
    }

    @Override
    public String createAIBehavior() {
        return "Aggressive Fire AI";
    }
}
