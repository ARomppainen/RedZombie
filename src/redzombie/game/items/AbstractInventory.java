package redzombie.game.items;

import java.util.Collection;

public interface AbstractInventory<T> extends Iterable<T> {
    public boolean contains(T item);
    public int index(T item);
    public T get(int index);
    public boolean remove(T item);
    public boolean remove(int index);
    public void add(AbstractItem item);
    public Collection getCollection();
}