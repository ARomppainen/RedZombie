package redzombie.game.items;

/**
 * The base class for stackable items (ammunition, throwing knives etc.)
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public abstract class StackableItem extends AbstractItem {
    
    private int stackSize;
    
    public StackableItem(String name, int count) {
        super(name);
        
        this.stackSize = count;
    }
    
    public int getCount() {
        return stackSize;
    }
    
    public void add(int amount) {
        stackSize += amount;
    }
}