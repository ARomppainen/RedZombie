package redzombie.game.characters;

import redzombie.game.level.Level;
import com.googlecode.lanterna.terminal.Terminal.Color;
import java.util.List;
import redzombie.game.DiceRoll;
import redzombie.game.items.AbstractInventory;
import redzombie.game.items.AbstractItem;
import redzombie.game.items.AmmoType;
import redzombie.game.items.Inventory;
import redzombie.game.items.ItemFactory;
import redzombie.game.level.AbstractGameObject;
import redzombie.game.level.Door;
import redzombie.game.level.GameObjectType;
import redzombie.util.Direction;
import redzombie.util.Util;
import redzombie.util.Vec2;


/**
 * An abstract class which represents characters in the game (Player, monsters etc.)
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public abstract class AbstractPerson {
    
    private Vec2 position;
    private String symbol;
    private Color color;
    private double sightRange;
    
    private int maxHealth;
    private int currentHealth;
    
    private AbstractInventory<AbstractItem> inventory;
    
    protected AbstractPerson(int x, int y, String symbol, Color color, double sightRange, int health) {
        this.position = new Vec2(x, y);
        this.symbol = symbol;
        this.color = color;
        this.sightRange = sightRange;
        
        this.maxHealth = health;
        this.currentHealth = health;
        
        this.inventory = new Inventory<>();
        
        inventory.add(ItemFactory.instance().createGrenade());
        inventory.add(ItemFactory.instance().createGrenade());
        inventory.add(ItemFactory.instance().createGrenade());
        inventory.add(ItemFactory.instance().createGrenade());
        inventory.add(ItemFactory.instance().createAmmo("9mm bullet", new DiceRoll(6), 5, AmmoType.PISTOL_AMMO));
        inventory.add(ItemFactory.instance().createHealthKit());
        inventory.add(ItemFactory.instance().createKnife());
        inventory.add(ItemFactory.instance().createHealthKit());
    }
    
    public void move(Direction d) {
        Vec2 pos = Util.newPos(position, d);
        position.set(pos);
    }
    
    public boolean canMove(Direction d, Level l) {
        Vec2 pos = Util.newPos(position, d);
        
        if (!Level.checkBounds(pos)) {
            return false;
        }
        
        return l.tiles.get(pos.y).get(pos.x).isPassable();
    }
    
    public Vec2 getPosition() {
        return position;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public Color getColor() {
        return color;
    }
    
    public double getSightRange() {
        return sightRange; // TODO: add modifiers...
    }
    
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
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public AbstractInventory<AbstractItem> getInventory() {
        return inventory;
    }
}
