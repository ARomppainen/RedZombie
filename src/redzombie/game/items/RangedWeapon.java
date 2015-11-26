package redzombie.game.items;

import redzombie.game.DiceRoll;

public class RangedWeapon extends Weapon {

    private AmmoType ammoType;
    private int clipSize;
    private int ammoCount;
    
    public RangedWeapon(String name, DiceRoll damageRoll, AmmoType ammoType, int clipSize, int ammoCount) {
        super(name, damageRoll);
        
        this.ammoType = ammoType;
        this.clipSize = clipSize;
        this.ammoCount = ammoCount;
    }
}