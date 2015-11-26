package redzombie;

import java.nio.charset.Charset;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import redzombie.game.Game;
import redzombie.rendering.Renderer;
import redzombie.rendering.RendererLOS;

public class RedZombie {
    
    private Screen screen;
    private Terminal terminal;
    private Game game;
    private Renderer renderer;
    
    public RedZombie() {
        
    }
    
    public void startGame() {
        initialize();
        mainLoop();
        cleanup();
    }
    
    private void initialize() {
        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
	screen = new Screen(terminal);
        
        screen.startScreen();
        screen.setCursorPosition(null); // hide cursor
        
        game = new Game(screen);
        renderer = new RendererLOS(screen, terminal);
    }
    
    private void mainLoop() {
        while(game.update()) {
            renderer.drawGameArea(game);
            renderer.drawStatistics(game);
        }
    }
    
    private void cleanup() {
        screen.stopScreen();
    }
}