package redzombie.game.items;

import redzombie.game.DiceRoll;

public class BuffItem extends StackableItem {

    BuffEffect effect;
    DiceRoll magnitude;
    
    public BuffItem(String name, int count, BuffEffect effect, DiceRoll magnitude) {
        super(name, count);
        
        this.effect = effect;
        this.magnitude = magnitude;
    }
}