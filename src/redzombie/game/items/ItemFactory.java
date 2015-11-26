package redzombie.game.items;

import redzombie.game.DiceRoll;

public class ItemFactory implements AbstractItemFactory {
    
    private static AbstractItemFactory instance = null;
    
    private ItemFactory() {
        
    }
    
    public static AbstractItemFactory instance() {
        if (instance == null) {
            instance = new ItemFactory();
        }
        
        return instance;
    }

    @Override
    public AbstractItem createAmmo(String name, int ammoCount, AmmoType type) {
        return new Ammo(
                name,
                ammoCount,
                type);
    }

    @Override
    public AbstractItem createFlashlight() {
        return null; // TODO: method stub
    }

    @Override
    public AbstractItem createGrenade() {
        return null; // TODO: method stub
    }

    @Override
    public AbstractItem createHealthKit() {
        return new BuffItem(
                "Health Kit",
                1,
                BuffEffect.HEALING_INSTANT,
                new DiceRoll(1, 10, 5));
    }

    @Override
    public AbstractItem createKnife() {
        return new MeleeWeapon(
                "Knife",
                new DiceRoll(1, 6, 1));
    }
}