package redzombie.game.state;

import redzombie.game.Game;

public abstract class AbstractGameState {
    
    protected Game game;
    
    protected AbstractGameState(Game g) {
        this.game = g;
    }
    
    public abstract GameState getState();
    public abstract boolean update();
}