package redzombie.game.items;

public class Ammo extends StackableItem {
    
    private AmmoType type;
    
    public Ammo(String name, int count, AmmoType type) {
        super(name, count);
        
        this.type = type;
    }
    
    public AmmoType getType() {
        return type;
    }
}