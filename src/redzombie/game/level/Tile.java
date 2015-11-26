package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;

public class Tile {
    public String symbol;
    public Color color;
    public boolean wall;
    public boolean destructible;
    
    public Tile() {
        this.symbol = " ";
        this.color = Terminal.Color.WHITE;
        this.wall = false;
        this.destructible = false;
    }
    
    public Tile(String symbol, Color color, boolean wall, boolean destructible) {
        this.symbol = symbol;
        this.color = color;
        this.wall = wall;
        this.destructible = destructible;
    }
}