package redzombie.rendering;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import redzombie.game.Game;
import redzombie.game.level.Tile;
import redzombie.util.Util;

public class RendererLOS extends Renderer {
    
    Screen screen;
    Terminal terminal;
    
    public RendererLOS(Screen screen, Terminal terminal) {
        this.screen = screen;
        this.terminal = terminal;
    }
    
    @Override
    public void drawGameArea(Game g) {
        screen.clear();
        
        // DRAW LINE OF SIGHT
        int minX = g.getPlayer().getPosition().x - (int)g.getPlayer().getSightRange();
        int maxX = g.getPlayer().getPosition().x + (int)g.getPlayer().getSightRange();
        int minY = g.getPlayer().getPosition().y - (int)g.getPlayer().getSightRange();
        int maxY = g.getPlayer().getPosition().y + (int)g.getPlayer().getSightRange();
        
        for (int i = minX; i <= maxX; ++i) {
            for (int j = minY; j <= maxY; ++j) {
                int dx = Math.abs(i - g.getPlayer().getPosition().x);
                int dy = Math.abs(j - g.getPlayer().getPosition().y);
                double dist = Math.sqrt(dx * dx + dy * dy);
                
                if (dist <= g.getPlayer().getSightRange()) {
                    if (Util.lineOfSight(g.getLevel(), g.getPlayer().getPosition().x, g.getPlayer().getPosition().y, i, j)) {
                        Tile t = g.getLevel().getTile(i, j);
                        
                        screen.putString(
                                i,
                                j,
                                t.getDisplayedSymbol(),
                                t.getDisplayedColor(),
                                Terminal.Color.BLACK);
                    }
                }
            }
        }
        
        // DRAW PLAYER
        screen.putString(
                g.getPlayer().getPosition().x,
                g.getPlayer().getPosition().y, 
                g.getPlayer().getSymbol(), 
                g.getPlayer().getColor(), 
                Terminal.Color.BLACK);
        
        screen.refresh();
    }
}