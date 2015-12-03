package redzombie.game;

import com.googlecode.lanterna.screen.Screen;

import java.util.Stack;

import redzombie.game.characters.AbstractPerson;
import redzombie.game.characters.PersonFactory;
import redzombie.game.level.Level;
import redzombie.game.state.AbstractGameState;
import redzombie.game.state.GameState;
import redzombie.game.state.LevelState;

/**
 * The main game-model class.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class Game {
    
    private final Screen screen;
    private Level level;
    private AbstractPerson player;
    
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
    }
    
    /**
     * Calls the update method of the top State.
     * 
     * @return True if the state is over, false otherwise.
     */
    public boolean update() {
        return states.peek().update();
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
    
    public GameState getCurrentState() {
        return states.peek().getState();
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
}