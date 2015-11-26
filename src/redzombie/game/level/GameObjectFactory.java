package redzombie.game.level;

public class GameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public AbstractGameObject createHorizontalDoor(boolean isOpen) {
        return new Door("/", "-", isOpen);
    }

    @Override
    public AbstractGameObject createVerticalDoor(boolean isOpen) {
        return new Door("/", "|", isOpen);
    }
}