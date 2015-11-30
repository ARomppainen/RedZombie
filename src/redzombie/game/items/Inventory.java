package redzombie.game.items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
    public void add(AbstractItem item) {
        item.addToInventory(this);
    }
    
    @Override
    public Collection getCollection() {
        return items;
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}