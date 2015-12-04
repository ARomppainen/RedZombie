package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * The class of all throwing weapons.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class ThrowingWeapon extends StackableItem implements AbstractRangedWeapon {

    private final DiceRoll damageRoll;
    private double range;
    private AreaOfEffect aoe;
    
    public ThrowingWeapon(String name, int count, DiceRoll damageRoll, double range) {
        super(name, count);
        
        this.damageRoll = damageRoll;
        this.range = range;
        this.aoe = null;
    }
    
    public ThrowingWeapon(String name, int count, DiceRoll damageRoll, double range, AreaOfEffect aoe) {
        super(name, count);
        
        this.damageRoll = damageRoll;
        this.range = range;
        this.aoe = aoe;
    }

    @Override
    public DiceRoll getDamageRoll() {
        return damageRoll;
    }

    @Override
    public double getRange() {
        return range;
    }

    @Override
    public AreaOfEffect getAOE() {
        return aoe;
    }
}