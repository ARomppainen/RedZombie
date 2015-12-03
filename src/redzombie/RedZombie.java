package redzombie;

import java.nio.charset.Charset;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import redzombie.game.Game;
import redzombie.rendering.AbstractRenderer;
import redzombie.rendering.Renderer;

/**
 * This class handles game initialization, termination and contains the game loop.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class RedZombie {
    
    /**
     * Terminal screen, used in rendering and input handling.
     */
    private Screen screen;
    
    /**
     * Terminal, used in rendering.
     */
    private Terminal terminal;
    
    private Game game;
    private AbstractRenderer renderer;
    
    public RedZombie() {
        
    }
    
    /**
     * This is the starting method for the program. Calls initialize, mainLoop
     * and cleanup methods in sequence.
     */
    public void startGame() {
        initialize();
        mainLoop();
        cleanup();
    }
    
    /**
     * Handles terminal & screen creation, enters private terminal mode &
     * creates game model + renderer.
     */
    private void initialize() {
        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
	screen = new Screen(terminal);
        
        screen.startScreen();
        screen.setCursorPosition(null); // hide cursor
        
        game = new Game(screen);
        renderer = new Renderer(screen, terminal);
    }

    /**
     * The main update + render -loop.
     */
    private void mainLoop() {
        while(game.isRunning()) {
            boolean pop = game.update();
            renderer.render(game);
            
            if (pop) {
                game.popState();
            }
        }
    }
    
    /**
     * Exits private terminal mode.
     */
    private void cleanup() {
        screen.stopScreen();
    }
}