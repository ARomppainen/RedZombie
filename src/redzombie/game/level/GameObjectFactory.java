package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal.Color;

/**
 * A singleton factory implementation for game object creation.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class GameObjectFactory implements AbstractGameObjectFactory {

    private static AbstractGameObjectFactory instance;
    
    private GameObjectFactory() {
        
    }
    
    /**
     * @return The singleton instance.
     */
    public static AbstractGameObjectFactory instance () {
        if (instance == null) {
            instance = new GameObjectFactory();
        }
        
        return instance;
    }
    
    @Override
    public AbstractGameObject createHorizontalDoor(Color color, boolean isOpen) {
        return new Door("/", "-", color, isOpen);
    }

    @Override
    public AbstractGameObject createVerticalDoor(Color color, boolean isOpen) {
        return new Door("/", "|", color, isOpen);
    }
}