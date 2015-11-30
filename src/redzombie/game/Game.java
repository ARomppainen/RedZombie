package redzombie.game;

import com.googlecode.lanterna.screen.Screen;
import java.util.Stack;

import redzombie.game.characters.AbstractPerson;
import redzombie.game.characters.PersonFactory;
import redzombie.game.level.Level;
import redzombie.game.state.AbstractGameState;
import redzombie.game.state.GameState;
import redzombie.game.state.LevelState;

public class Game {
    
    private final Screen screen;
    private Level level;
    private AbstractPerson player;
    
    private Stack<AbstractGameState> states;
    
    public Game(Screen screen) {
        this.screen = screen;
        
        level = new Level();
        player = PersonFactory.instance().createPlayer();
        
        states = new Stack<>();
        states.push(new LevelState(this));
        //levelState = new LevelState(this);
    }
    
    public boolean update() {
        //return currentState.update();
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
        //return currentState.getState();
        return states.peek().getState();
    }
    
    public boolean isRunning() {
        return states.size() > 0;
    }
    
    public void pushState(AbstractGameState s) {
        states.push(s);
    }
    
    public void popState() {
        states.pop();
    }
}