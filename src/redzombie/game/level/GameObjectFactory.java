package redzombie.game.level;

public class GameObjectFactory implements AbstractGameObjectFactory {

    private static AbstractGameObjectFactory instance;
    
    private GameObjectFactory() {
        
    }
    
    public static AbstractGameObjectFactory instance () {
        if (instance == null) {
            instance = new GameObjectFactory();
        }
        
        return instance;
    }
    
    @Override
    public AbstractGameObject createHorizontalDoor(boolean isOpen) {
        return new Door("/", "-", isOpen);
    }

    @Override
    public AbstractGameObject createVerticalDoor(boolean isOpen) {
        return new Door("/", "|", isOpen);
    }
}