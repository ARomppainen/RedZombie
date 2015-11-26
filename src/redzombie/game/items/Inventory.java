package redzombie.game.items;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements AbstractInventory {

    private final List<AbstractItem> items;
    
    public Inventory() {
        items = new ArrayList<>();
    }
    
    @Override
    public boolean contains(AbstractItem item) {
        return items.contains(item);
    }

    @Override
    public int index(AbstractItem item) {
        return items.indexOf(item);
    }

    @Override
    public AbstractItem get(int index) {
        return items.get(index);
    }

    @Override
    public boolean remove(AbstractItem item) {
        return items.remove(item);
    }

    @Override
    public boolean remove(int index) {
        return items.remove(index) != null;
    }
    
    @Override
    public void add(AbstractItem item) {
        item.addToInventory(this);
    } 
}