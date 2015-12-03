package redzombie.game.items;

/**
 * This class represents (stackable) ammunition used by ranged weapons.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
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