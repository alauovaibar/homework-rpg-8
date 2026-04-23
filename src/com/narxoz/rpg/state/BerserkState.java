package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;
public class BerserkState implements HeroState {
    public String getName() { return "Berserk"; }
    public int modifyOutgoingDamage(int base) { return (int)(base * 1.5); }
    public int modifyIncomingDamage(int raw) { return (int)(raw * 1.2); }
    public void onTurnStart(Hero h) { System.out.println(h.getName() + " охвачен яростью!"); }
    public void onTurnEnd(Hero h) {}
    public boolean canAct() { return true; }
}