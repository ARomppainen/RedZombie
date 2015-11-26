package redzombie.game.characters;

import redzombie.game.level.Level;
import redzombie.util.Direction;
import redzombie.util.Vec2;
import com.googlecode.lanterna.terminal.Terminal.Color;
import java.util.List;
import redzombie.game.level.AbstractGameObject;
import redzombie.game.level.Door;
import redzombie.game.level.GameObjectType;
import redzombie.util.Util;

public class Person implements AbstractPerson {
    
    private Vec2 position;
    private String symbol;
    private Color color;
    private double sightRange;
    
    private int maxHealth;
    private int currentHealth;
    
    public Person(int x, int y, String symbol, Color color, double sightRange, int health) {
        this.position = new Vec2(x, y);
        this.symbol = symbol;
        this.color = color;
        this.sightRange = sightRange;
        this.maxHealth = health;
        this.currentHealth = health;
    }
    
    @Override
    public void move(Direction d) {
        Vec2 pos = Util.newPos(position, d);
        position.set(pos);
        
        /*
        switch (d) {
            case UP:    position.add(0, -1);    break;
            case DOWN:  position.add(0, 1);     break;
            case LEFT:  position.add(-1, 0);    break;
            case RIGHT: position.add(1, 0);     break;
        }
        */
    }
    
    @Override
    public boolean canMove(Direction d, Level l) {
        Vec2 pos = Util.newPos(position, d);
        
        /*      
        Vec2 pos = new Vec2(position);
        
        switch (d) {
            case UP:    pos.add(0, -1);    break;
            case DOWN:  pos.add(0, 1);     break;
            case LEFT:  pos.add(-1, 0);    break;
            case RIGHT: pos.add(1, 0);     break;
        }
        */
        
        /*
        if (pos.x < 0 || pos.x >= Level.WIDTH || pos.y < 0 || pos.y >= Level.HEIGHT) {
            return false;
        }
        */
        
        if (!Level.checkBounds(pos)) {
            return false;
        }
        
        return l.tiles.get(pos.y).get(pos.x).isPassable();
    }
    
    public boolean canAttack(Direction d, Level l) {
        return false; // TODO: method stub
    }

    @Override
    public Vec2 getPosition() {
        return position;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public double getSightRange() {
        return sightRange;
    }
    
    @Override
    public boolean tryOpenDoor(Level l) {
        boolean success = false;
        List<AbstractGameObject> objs = Util.findObjectsNextTo(l, position);
        
        
        for(AbstractGameObject o : objs) {
            if (o.getType() == GameObjectType.DOOR) {
                success = true;
                Door door = (Door)o;
                door.toggle();
            }
        }
        
        return success;
    }
}