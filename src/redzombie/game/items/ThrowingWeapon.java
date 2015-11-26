package redzombie.game.items;

import redzombie.game.DiceRoll;

public class ThrowingWeapon extends StackableItem implements AbstractRangedWeapon {

    private final DiceRoll damageRoll;
    private double range;
    
    public ThrowingWeapon(String name, int count, DiceRoll damageRoll, double range) {
        super(name, count);
        
        this.damageRoll = damageRoll;
        this.range = range;
    }

    @Override
    public DiceRoll getDamageRoll() {
        return damageRoll;
    }

    @Override
    public double getRange() {
        return range;
    }
}