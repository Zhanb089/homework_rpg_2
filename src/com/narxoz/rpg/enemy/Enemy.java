package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.Map;


public interface Enemy {

    String getName();
    void setName(String name);
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    void multiplyStats(double multiplier);
    List<Ability> getAbilities();
    Map<Integer, Integer> getPhases();
    LootTable getLootTable();
    String getAIBehavior();
    boolean canFly();
    boolean hasBreathAttack();
    int getWingspan();
    void displayInfo();
    Enemy clone();
    

}
