package redzombie.game.items;

/**
 * Interface for inventories. Inventories hold (abstract) items. (Player) characters,
 * and world tiles have inventories.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public interface AbstractInventory<T> extends Iterable<T> {
    public boolean contains(T item);
    public int index(T item);
    public T get(int index);
    public boolean remove(T item);
    public boolean remove(int index);
    public void add(T item);
}