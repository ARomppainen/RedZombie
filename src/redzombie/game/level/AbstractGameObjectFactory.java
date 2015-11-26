package redzombie.game.level;

public interface AbstractGameObjectFactory {
    public AbstractGameObject createHorizontalDoor(boolean isOpen);
    public AbstractGameObject createVerticalDoor(boolean isOpen);
}