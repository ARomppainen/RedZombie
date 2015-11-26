package redzombie.game.items;

public interface AbstractItemFactory {
    public AbstractItem createAmmo(String name, AmmoType type, int ammoCount);
    public AbstractItem createFlashlight();
    public AbstractItem createGrenade();
    public AbstractItem createHealthKit();
    public AbstractItem createKnife();
}