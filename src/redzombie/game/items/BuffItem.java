package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * This class represents items with all kinds of buff effects.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class BuffItem extends StackableItem {

    Buff effect;
    DiceRoll magnitude;
    
    public BuffItem(String name, int count, Buff effect, DiceRoll magnitude) {
        super(name, count);
        
        this.effect = effect;
        this.magnitude = magnitude;
    }
}