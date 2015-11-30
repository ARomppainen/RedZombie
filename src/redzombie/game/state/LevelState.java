package redzombie.game.state;

import com.googlecode.lanterna.input.Key;
import redzombie.game.Game;
import redzombie.util.Direction;

public class LevelState extends AbstractGameState {

    public LevelState(Game g) {
        super(g);
    }

    @Override
    public GameState getState() {
        return GameState.STATE_LEVEL;
    }

    @Override
    public boolean update() {
        Key k = game.getScreen().readInput();
        
        if (k != null ) {
            if (k.isAltPressed() && k.getCharacter() == 'q') {
                return true;
            }
            
            if (k.getKind() == Key.Kind.ArrowDown) {
                if (game.getPlayer().canMove(Direction.DOWN, game.getLevel())) {
                    game.getPlayer().move(Direction.DOWN);
                }
            } else if (k.getKind() == Key.Kind.ArrowLeft) {
                if (game.getPlayer().canMove(Direction.LEFT, game.getLevel())) {
                    game.getPlayer().move(Direction.LEFT);
                }
            } else if (k.getKind() == Key.Kind.ArrowRight) {
                if (game.getPlayer().canMove(Direction.RIGHT, game.getLevel())) {
                    game.getPlayer().move(Direction.RIGHT);
                }
            } else if (k.getKind() == Key.Kind.ArrowUp) {
                if (game.getPlayer().canMove(Direction.UP, game.getLevel())) {
                    game.getPlayer().move(Direction.UP);
                }
            } else if (k.getCharacter() == 'c' || k.getCharacter() == 'C') {
                game.getPlayer().tryOpenDoor(game.getLevel());
            } else if (k.getCharacter() == 'e' || k.getCharacter() == 'E') {
                game.pushState(new InventoryState(game));
            }
        }
        
        return false;
    }
}