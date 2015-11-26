package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal;

public interface AbstractGameObject {
    public String getSymbol();
    public Terminal.Color getColor();
    public boolean isPassable();
}
