package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal.Color;

/**
 * The base class for all the static (interactable) objects found in levels.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public interface AbstractGameObject {
    public String getSymbol();
    public Color getColor();
    public boolean isPassable();
    public GameObjectType getType();
}