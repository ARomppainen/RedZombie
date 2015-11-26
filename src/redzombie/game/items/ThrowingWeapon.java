package redzombie.game.items;

import redzombie.game.DiceRoll;

public class ThrowingWeapon extends Weapon implements Stackable {

    public ThrowingWeapon(String name, DiceRoll damageRoll) {
        super(name, damageRoll);
    }
}