package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * The class for all ranged weapons.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class RangedWeapon extends AbstractItem implements AbstractRangedWeapon {

    private DiceRoll damageRoll;
    
    private AmmoType ammoType;
    private int clipSize;
    private int ammoCount;
    
    private Ammo ammo;
    
    private double range;
    
    public RangedWeapon(String name, DiceRoll damageRoll, AmmoType ammoType, int clipSize, double range) {
        super(name);
        
        this.damageRoll = damageRoll;
        this.ammoType = ammoType;
        this.clipSize = clipSize;
        
        this.ammoCount = 0;
        this.ammo = null;
        
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
    
    public void setAmmo(Ammo a) {
        this.ammo = a;
        reload();
    }
    
    public void reload() {
        // TODO: method stub
    }
}