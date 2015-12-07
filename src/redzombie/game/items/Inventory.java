package redzombie.game.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The main Inventory implementation.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class Inventory<T> implements AbstractInventory<T> {

    private final List<T> items;
    
    public Inventory() {
        items = new ArrayList<>();
    }
    
    @Override
    public boolean contains(T item) {
        return items.contains(item);
    }

    @Override
    public int index(T item) {
        return items.indexOf(item);
    }

    @Override
    public T get(int index) {
        return items.get(index);
    }

    @Override
    public boolean remove(T item) {
        return items.remove(item);
    }

    @Override
    public boolean remove(int index) {
        return items.remove(index) != null;
    }
    
    @Override
    public void add(T item) {
        if (item instanceof StackableItem) {
            int index = index(item);
            
            if (index >= 0) {
                StackableItem sItem = (StackableItem)item;
                StackableItem item2 = (StackableItem)get(index);
                item2.add(sItem.getCount());
            } else {
                items.add(item);
            }
        } else {
            items.add(item);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}