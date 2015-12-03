package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * The for all melee weapons.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
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