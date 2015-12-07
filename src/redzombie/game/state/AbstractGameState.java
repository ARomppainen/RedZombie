package redzombie.game.state;

import redzombie.game.Game;

/**
 * The base class for all game states.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public abstract class AbstractGameState {
    
    protected Game game;
    
    protected AbstractGameState(Game g) {
        this.game = g;
    }
    
    public abstract GameState getType();
    public abstract boolean update();
}