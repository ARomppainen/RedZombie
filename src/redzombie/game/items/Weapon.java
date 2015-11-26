package redzombie.game.items;

import redzombie.game.DiceRoll;

public abstract class Weapon extends AbstractItem {
    
    private DiceRoll damageRoll;
    
    protected Weapon(String name, DiceRoll damageRoll) {
        super(name);
        
        this.damageRoll = damageRoll;
    }
    
    public DiceRoll getDamageRoll() {
        return damageRoll;
    }
}