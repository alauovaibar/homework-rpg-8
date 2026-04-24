package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.state.BerserkState;
import java.util.*;

public class CombatFloor extends TowerFloor {
    private Monster monster;
    private final String floorName;

    public CombatFloor(String name) { this.floorName = name; }

    protected String getFloorName() { return floorName; }

    protected void setup(List<Hero> party) {
        this.monster = new Monster("Теневой Рыцарь", 50, 15);
    }

    protected FloorResult resolveChallenge(List<Hero> party) {
        int totalDamage = 0;
        while (monster.isAlive() && party.stream().anyMatch(Hero::isAlive)) {
            for (Hero hero : party) {
                if (hero.isAlive()) {
                    monster.takeDamage(hero.calculateAttack());
                    if (monster.isAlive()) {
                        int dmg = monster.getAttackPower();
                        hero.takeDamage(dmg);
                        totalDamage += dmg;
                    }
                }
            }
        }
        return new FloorResult(monster.getHp() <= 0, totalDamage, "Битва с " + monster.getName());
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {
        System.out.println("Герои нашли зелье ярости!");
        party.get(0).setState(new BerserkState());
    }
}