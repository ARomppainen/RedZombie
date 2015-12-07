package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * The base class for all weapon types.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public interface AbstractWeapon {
    public DiceRoll getDamageRoll();
}