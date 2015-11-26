package redzombie.game.items;

public class Ammo extends AbstractItem implements Stackable {
    
    private AmmoType type;
    private int stackSize;
    
    public Ammo(String name, AmmoType type, int stackSize) {
        super(name);
        
        this.type = type;
        this.stackSize = stackSize;
    }
    
    public AmmoType getType() {
        return type;
    }
    
    public int getStackSize() {
        return stackSize;
    }
}
