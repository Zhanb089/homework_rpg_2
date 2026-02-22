package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class FireLootTable implements LootTable{
    private final List<String> drops = Arrays.asList(
            "Flame Sword", "Burning Armor", "Phoenix Feather"
    );

    @Override
    public List<String> getDrops() {
        return drops;
    }

    @Override
    public LootTable clone() {
        return new FireLootTable();
    }
}
