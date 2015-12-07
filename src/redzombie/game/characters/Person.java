package redzombie.game.characters;

import com.googlecode.lanterna.terminal.Terminal.Color;

/**
 * A class which represents the player controller character.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class Person extends AbstractPerson {
    
    public Person(int x, int y, String symbol, Color color, double sightRange, int health) {
        super(x, y, symbol, color, sightRange, health);
    }
}