package redzombie.game.items;

import redzombie.game.DiceRoll;

public class MeleeWeapon extends AbstractItem implements AbstractWeapon {

    private DiceRoll damageRoll;
    
    public MeleeWeapon(String name, DiceRoll damageRoll) {
        super(name);
        
        this.damageRoll = damageRoll;
    }

    @Override
    public DiceRoll getDamageRoll() {
        return damageRoll;
    }
}