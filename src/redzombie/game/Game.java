package redzombie.game;

import com.googlecode.lanterna.screen.Screen;

import java.util.Stack;

import redzombie.game.characters.AbstractPerson;
import redzombie.game.characters.PersonFactory;
import redzombie.game.level.Level;
import redzombie.game.state.AbstractGameState;
import redzombie.game.state.LevelState;
import redzombie.util.Config;

/**
 * The main game-model class.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class Game {
    
    private final Screen screen;
    private Level level;
    private AbstractPerson player;
    private long deltaTime;
    
    /**
     * A stack of game states, only the top one is rendered.
     */
    private Stack<AbstractGameState> states;
    
    public Game(Screen screen) {
        this.screen = screen;
        
        level = new Level();
        player = PersonFactory.instance().createPlayer();
        
        states = new Stack<>();
        states.push(new LevelState(this));
        
        deltaTime = 0;
    }
    
    /**
     * Calls the update method of the top State.
     * 
     * @return True if the state is over, false otherwise.
     */
    public boolean update() {
        long time = System.currentTimeMillis();
        boolean b =  states.peek().update();
        deltaTime = System.currentTimeMillis() - time;
        
        if (Config.LIMIT_FPS) {
            if (deltaTime < Config.TARGET_FRAME_MS) {
                try {
                    Thread.sleep(Config.TARGET_FRAME_MS - deltaTime);
                } catch (Exception e) {}

                deltaTime = Config.TARGET_FRAME_MS;
            } else if (deltaTime > Config.MAX_FRAME_MS) {
                deltaTime = Config.MAX_FRAME_MS;
            }
        }
        
        return b;
    }
    
    public Level getLevel() {
        return level;
    }
    
    public AbstractPerson getPlayer() {
        return player;
    }
    
    public Screen getScreen() {
        return screen;
    }
    
    public AbstractGameState getGameState() {
        return states.peek();
    }
    
    /**
     * Checks if the game should be closed.
     * 
     * @return True if the state stack has one or more states, false if not.
     */
    public boolean isRunning() {
        return states.size() > 0;
    }
    
    /**
     * Adds a new game state to the top of the stack.
     * 
     * @param s The new game state to be added.
     */
    public void pushState(AbstractGameState s) {
        states.push(s);
    }
    
    /**
     * Removes the top game state from the stack.
     */
    public void popState() {
        states.pop();
    }
    
    /**
     * Returns the time it took to run the latest update (in milliseconds).
     * 
     * @return delta time (in milliseconds)
     */
    public long getDeltaTime() {
        return deltaTime;
    }
}