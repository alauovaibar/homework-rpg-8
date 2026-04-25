package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import com.narxoz.rpg.tower.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Hero> party = new ArrayList<>();
        party.add(new Hero("Арагорн", 100, 20, 5));
        party.add(new Hero("Леголас", 80, 25, 2));

        List<TowerFloor> tower = Arrays.asList(
                new CombatFloor("Нижний ярус"),
                new TrapFloor(),
                new CombatFloor("Зал теней"),
                new CombatFloor("Вершина башни")
        );

        TowerRunner runner = new TowerRunner(tower);
        TowerRunResult result = runner.run(party);

        System.out.println("\n=== ИТОГИ ПОХОДА ===");
        System.out.println("Пройдено этажей: " + result.getFloorsCleared());
        System.out.println("Выжило героев: " + result.getHeroesSurviving());
        System.out.println("Башня покорена: " + (result.isReachedTop() ? "ДА!" : "НЕТ"));
    }
}