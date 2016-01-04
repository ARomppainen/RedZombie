package redzombie.game.state;

import com.googlecode.lanterna.input.Key;
import redzombie.game.Game;
import redzombie.game.Renderer;

/**
 * The state for viewing the player's inventory.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class InventoryState extends AbstractGameState {

    private int index;
    
    public InventoryState(Game g) {
        super(g);
        
        this.index = 0;
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

    @Override
    public void render() {
        Renderer.resetBackground();
        Renderer.drawInventory(game.getPlayer().getInventory());
    }
}