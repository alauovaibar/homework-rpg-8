package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.state.PoisonState;

import java.util.List;

public class TrapFloor extends TowerFloor {
    protected String getFloorName() { return "Загадочный коридор"; }
    protected void setup(List<Hero> party) {}

    protected FloorResult resolveChallenge(List<Hero> party) {
        for (Hero h : party) h.setState(new PoisonState());
        return new FloorResult(true, 0, "Вы попали в облако ядовитого газа!");
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {}
}