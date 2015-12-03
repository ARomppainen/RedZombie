package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal.Color;

/**
 * An abstract factory for game object creation.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public interface AbstractGameObjectFactory {
    public AbstractGameObject createHorizontalDoor(Color color, boolean isOpen);
    public AbstractGameObject createVerticalDoor(Color color, boolean isOpen);
}