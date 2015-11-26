package redzombie.game.items;

public abstract class StackableItem extends AbstractItem {
    
    private int stackSize;
    
    public StackableItem(String name, int count) {
        super(name);
        
        this.stackSize = count;
    }
    
    @Override
    public void addToInventory(AbstractInventory inv) {
        int index = inv.index(this);
        
        if (index >= 0) {
            StackableItem item = (StackableItem)inv.get(index);
            item.stackSize += this.stackSize;
        } else {
            inv.add(this);
        }
    }
    
    public int getCount() {
        return stackSize;
    }
}