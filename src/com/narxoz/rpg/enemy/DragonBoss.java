package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DragonBoss implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public DragonBoss(String name, int health, int damage, int defense, int speed,
                      String element, List<Ability> abilities,
                      int phase1, int phase2, int phase3,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        this.phases = new HashMap<>();
        this.phases.put(1, phase1);
        this.phases.put(2, phase2);
        this.phases.put(3, phase3);
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public String getElement() { return element; }
    public List<Ability> getAbilities() { return abilities; }
    public Map<Integer, Integer> getPhases() { return phases; }
    public LootTable getLootTable() { return lootTable; }
    public String getAIBehavior() { return aiBehavior; }
    public boolean canFly() { return canFly; }
    public boolean hasBreathAttack() { return hasBreathAttack; }
    public int getWingspan() { return wingspan; }

    public void displayInfo() {
        System.out.println("=== " + name + " (DragonBoss) ===");
        System.out.println("Health: " + health + ", Damage: " + damage +
                ", Defense: " + defense + ", Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities: " + abilities.size());
        System.out.println("Phases: " + phases);
        System.out.println("AI: " + aiBehavior + ", CanFly: " + canFly +
                ", BreathAttack: " + hasBreathAttack + ", Wingspan: " + wingspan);
    }
    @Override
    public Enemy clone() {
        // Клонируем DragonBoss, создавая новый объект с теми же параметрами
        DragonBoss copy = new DragonBoss(
                this.name,
                this.health,
                this.damage,
                this.defense,
                this.speed,
                this.element,
                new ArrayList<>(this.abilities),   // копия списка
                this.phases.getOrDefault(1, 0),
                this.phases.getOrDefault(2, 0),
                this.phases.getOrDefault(3, 0),
                this.lootTable,
                this.aiBehavior,
                this.canFly,
                this.hasBreathAttack,
                this.wingspan
        );

        // Копируем карту фаз
        copy.getPhases().putAll(this.phases);

        return copy;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
    }

}
