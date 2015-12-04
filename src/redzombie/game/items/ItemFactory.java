package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * A singleton factory implementation for item creation.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class ItemFactory implements AbstractItemFactory {
    
    private static AbstractItemFactory instance = null;
    
    private ItemFactory() {
        
    }
    
    /**
     * @return The singleton instance.
     */
    public static AbstractItemFactory instance() {
        if (instance == null) {
            instance = new ItemFactory();
        }
        
        return instance;
    }

    @Override
    public AbstractItem createAmmo(String name, DiceRoll damageRoll, int ammoCount, AmmoType type) {
        return new Ammo(
                name,
                damageRoll,
                ammoCount,
                type);
    }

    @Override
    public AbstractItem createFlashlight() {
        return null; // TODO: method stub
    }

    @Override
    public AbstractItem createGrenade() {
        return new ThrowingWeapon(
                "Grenade",
                1,
                new DiceRoll(10),
                2.5);
    }

    @Override
    public AbstractItem createHealthKit() {
        return new BuffItem(
                "Health Kit",
                1,
                Buff.HEALING_INSTANT,
                new DiceRoll(1, 10, 5));
    }

    @Override
    public AbstractItem createKnife() {
        return new MeleeWeapon(
                "Knife",
                new DiceRoll(1, 6, 1));
    }
}