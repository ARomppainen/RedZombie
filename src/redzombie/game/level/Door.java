package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal.Color;

/**
 * A simple two state door.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class Door implements AbstractGameObject {

    private final String symbolOpen;
    private final String symbolClosed;
    private Color color;
    
    private boolean open;
    
    public Door(String symbolOpen, String symbolClosed, Color color, boolean isOpen) {
        this.symbolOpen = symbolOpen;
        this.symbolClosed = symbolClosed;
        this.color = color;
        this.open = isOpen;
    }
    
    @Override
    public String getSymbol() {
        if (open) {
            return symbolOpen;
        } else {
            return symbolClosed;
        }
    }
    
    @Override
    public boolean isPassable() {
        return isOpen();
    }
    
    @Override
    public Color getColor() {
        return color;
    }
    
    @Override
    public GameObjectType getType() {
        return GameObjectType.DOOR;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public void toggle() {
        open = !open;
    }
}
