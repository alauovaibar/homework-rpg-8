package com.narxoz.rpg.tower;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import java.util.*;

public class TowerRunner {
    private final List<TowerFloor> floors;

    public TowerRunner(List<TowerFloor> floors) { this.floors = floors; }

    public TowerRunResult run(List<Hero> party) {
        int cleared = 0;
        for (TowerFloor floor : floors) {
            if (party.stream().noneMatch(Hero::isAlive)) break;

            FloorResult res = floor.explore(party);
            if (res.isCleared()) cleared++;
            else break;
        }
        long survivors = party.stream().filter(Hero::isAlive).count();
        return new TowerRunResult(cleared, (int) survivors, cleared == floors.size());
    }
}