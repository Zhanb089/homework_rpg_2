package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class ShadowLootTable implements LootTable{
     private final List<String> drops = Arrays.asList(
            "Shadow Dagger", "Dark Cloak", "Soul Fragment"
    );

    @Override
    public List<String> getDrops() {
        return drops;
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable();
    }
}
