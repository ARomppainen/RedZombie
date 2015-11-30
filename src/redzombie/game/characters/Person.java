package redzombie.game.characters;

import com.googlecode.lanterna.terminal.Terminal.Color;

import java.util.List;

import redzombie.game.level.Level;
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

public class Person implements AbstractPerson {
    
    private Vec2 position;
    private String symbol;
    private Color color;
    private double sightRange;
    
    private int maxHealth;
    private int currentHealth;
    
    private AbstractInventory<AbstractItem> inventory;
    
    public Person(int x, int y, String symbol, Color color, double sightRange, int health) {
        this.position = new Vec2(x, y);
        this.symbol = symbol;
        this.color = color;
        this.sightRange = sightRange;
        this.maxHealth = health;
        this.currentHealth = health;
        
        this.inventory = new Inventory<>();
        inventory.add(ItemFactory.instance().createKnife());
        inventory.add(ItemFactory.instance().createHealthKit());
        inventory.add(ItemFactory.instance().createAmmo("dksjahfdsfkj", 6, AmmoType.PISTOL_AMMO));
        inventory.add(ItemFactory.instance().createHealthKit());
    }
    
    @Override
    public void move(Direction d) {
        Vec2 pos = Util.newPos(position, d);
        position.set(pos);
    }
    
    @Override
    public boolean canMove(Direction d, Level l) {
        Vec2 pos = Util.newPos(position, d);
        
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
    
    @Override
    public int getMaxHealth() {
        return maxHealth;
    }
    
    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    @Override
    public AbstractInventory<AbstractItem> getInventory() {
        return inventory;
    }
}