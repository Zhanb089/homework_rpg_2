package com.narxoz.rpg.factory;

import java.util.List;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.ShadowAbility;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.ShadowLootTable;

public class ShadowComponentFactory implements EnemyComponentFactory{

    @Override
    public List<Ability> createAbilities() {
        return List.of(
                new ShadowAbility("Dark Slash", 130),
                new ShadowAbility("Soul Drain", 220)
        );
    }

    @Override
    public LootTable createLootTable() {
        return new ShadowLootTable();
    }

    @Override
    public String createAIBehavior() {
        return "Stealth Shadow AI";
    }
    
}
