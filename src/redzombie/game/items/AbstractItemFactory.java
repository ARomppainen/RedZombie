package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * An abstract factory for item creation.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public interface AbstractItemFactory {
    public AbstractItem createAmmo(String name, DiceRoll damageRoll, int ammoCount, AmmoType type);
    public AbstractItem createFlashlight();
    public AbstractItem createGrenade();
    public AbstractItem createHealthKit();
    public AbstractItem createKnife();
}