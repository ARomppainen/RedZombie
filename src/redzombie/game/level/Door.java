package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal;

public class Door implements AbstractGameObject {

    private final String symbolOpen;
    private final String symbolClosed;
    
    boolean open;
    
    public Door(String symbolOpen, String symbolClosed, boolean isOpen) {
        this.symbolOpen = symbolOpen;
        this.symbolClosed = symbolClosed;
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
    public Terminal.Color getColor() {
        return Terminal.Color.MAGENTA;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public void toggle() {
        open = !open;
    }
}
