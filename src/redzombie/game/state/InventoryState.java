package redzombie.game.state;

import com.googlecode.lanterna.input.Key;
import redzombie.game.Game;

public class InventoryState extends AbstractGameState {

    private int index;
    
    public InventoryState(Game g) {
        super(g);
        
        this.index = 0;
    }

    @Override
    public GameState getState() {
        return GameState.STATE_INVENTORY;
    }

    @Override
    public boolean update() {
        Key k = game.getScreen().readInput();
        
        if (k != null) {
            if (k.getKind() == Key.Kind.Escape) {
                return true;
            }
        }
        
        return false;
    }
}