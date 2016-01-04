package redzombie.game.state;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal.Color;
import redzombie.game.Game;
import redzombie.game.items.CircleAOE;
import redzombie.game.Renderer;
import redzombie.util.Direction;
import redzombie.util.Vec2;

/**
 * The state which displays the player in level + statistics.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class LevelState extends AbstractGameState {

    public LevelState(Game g) {
        super(g);
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
            } else if (k.getCharacter() == 't' || k.getCharacter() == 'T') {
                game.pushState(new TargetingState(game, new CircleAOE(game.getPlayer().getPosition(), 2.5)));
            }
        }
        
        return false;
    }

    @Override
    public void render() {
        Renderer.resetBackground();
        Renderer.drawLOS(game);
        Renderer.drawPlayer(game.getPlayer());
        Renderer.drawStatistics(game);
        
        Renderer.putStringDebug(new Vec2(81, 0), "Debug:", Color.WHITE);
        Renderer.putStringDebug(new Vec2(81, 1), "LevelState", Color.WHITE);
        Renderer.putStringDebug(new Vec2(81, 2), "DeltaTime: " + Long.toString(game.getDeltaTime()), Color.WHITE);
    }
}