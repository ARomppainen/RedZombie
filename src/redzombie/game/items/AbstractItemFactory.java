package redzombie.game.items;

public interface AbstractItemFactory {
    public AbstractItem createAmmo(String name, int ammoCount, AmmoType type);
    public AbstractItem createFlashlight();
    public AbstractItem createGrenade();
    public AbstractItem createHealthKit();
    public AbstractItem createKnife();
}