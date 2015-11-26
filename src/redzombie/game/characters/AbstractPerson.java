package redzombie.game.characters;

import redzombie.game.level.Level;
import com.googlecode.lanterna.terminal.Terminal.Color;
import redzombie.util.Direction;
import redzombie.util.Vec2;

public interface AbstractPerson {
    public void move(Direction d);
    public boolean canMove(Direction d, Level l);
    
    public Vec2 getPosition();
    public String getSymbol();
    public Color getColor();
    public double getSightRange();
    
    public boolean tryOpenDoor(Level l);
}