package redzombie.game.items;

import redzombie.game.DiceRoll;

public class BuffItem extends AbstractItem implements Stackable {

    BuffEffect effect;
    DiceRoll magnitude;
    
    public BuffItem(String name, BuffEffect effect, DiceRoll magnitude) {
        super(name);
        
        this.effect = effect;
        this.magnitude = magnitude;
    }
}