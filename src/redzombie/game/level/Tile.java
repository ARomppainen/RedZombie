package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;

/**
 * The Tile class.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class Tile {
    public String symbol;
    public Color color;
    public boolean wall;
    public boolean destructible;
    
    public AbstractGameObject obj;
    
    public Tile() {
        this.symbol = " ";
        this.color = Terminal.Color.WHITE;
        this.wall = false;
        this.destructible = false;
        this.obj = null;
    }
    
    public Tile(String symbol, Color color, boolean wall, boolean destructible) {
        this.symbol = symbol;
        this.color = color;
        this.wall = wall;
        this.destructible = destructible;
        this.obj = null;
    }
    
    public String getDisplayedSymbol() {
        if (obj != null) {
            return obj.getSymbol();
        }
        
        return symbol;
    }
    
    public Color getDisplayedColor() {
        if (obj != null) {
            return obj.getColor();
        }
        
        return color;
    }
    
    public boolean isPassable() {
        if (obj != null) {
            return obj.isPassable();
        } else {
            return !wall;
        }
    }
}