package redzombie.game.items;

public interface AbstractInventory {
    public boolean contains(AbstractItem item);
    public int index(AbstractItem item);
    public AbstractItem get(int index);
    public boolean remove(AbstractItem item);
    public boolean remove(int index);
    public void add(AbstractItem item);
}