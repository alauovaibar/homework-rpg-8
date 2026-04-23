package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;
public class PoisonState implements HeroState {
    private int duration = 3;
    public String getName() { return "Poisoned"; }
    public int modifyOutgoingDamage(int base) { return base; }
    public int modifyIncomingDamage(int raw) { return raw; }
    public void onTurnStart(Hero h) {
        System.out.println(h.getName() + " теряет 5 HP от яда!");
        h.takeDamage(5);
    }
    public void onTurnEnd(Hero h) {
        duration--;
        if (duration <= 0) {
            System.out.println("Яд в крови " + h.getName() + " иссяк.");
            h.setState(new NormalState());
        }
    }
    public boolean canAct() { return true; }
}