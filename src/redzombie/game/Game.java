package redzombie.game;

import redzombie.game.characters.AbstractPerson;
import redzombie.game.characters.PersonFactory;
import redzombie.game.level.Level;
import redzombie.util.Direction;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;

public class Game {
    
    private final Screen screen;
    private Level level;
    private AbstractPerson player;
    
    public Game(Screen screen) {
        this.screen = screen;
        
        level = new Level();
        player = PersonFactory.instance().createPlayer();
    }
    
    public boolean update() {
        Key k = screen.readInput();
        
        if (k != null ) {
            if (k.isAltPressed() && k.getCharacter() == 'q') {
                return false;
            }
            
            if (k.getKind() == Key.Kind.ArrowDown) {
                if (player.canMove(Direction.DOWN, level)) {
                    player.move(Direction.DOWN);
                }
            } else if (k.getKind() == Key.Kind.ArrowLeft) {
                if (player.canMove(Direction.LEFT, level)) {
                    player.move(Direction.LEFT);
                }
            } else if (k.getKind() == Key.Kind.ArrowRight) {
                if (player.canMove(Direction.RIGHT, level)) {
                    player.move(Direction.RIGHT);
                }
            } else if (k.getKind() == Key.Kind.ArrowUp) {
                if (player.canMove(Direction.UP, level)) {
                    player.move(Direction.UP);
                }
            }
        }
        
        return true;
    }
    
    public Level getLevel() {
        return level;
    }
    
    public AbstractPerson getPlayer() {
        return player;
    }
}