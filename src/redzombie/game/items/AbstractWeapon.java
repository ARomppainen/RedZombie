package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * The base class for all weapon types.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public interface AbstractWeapon {
    public DiceRoll getDamageRoll();
}