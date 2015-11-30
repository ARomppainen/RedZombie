package redzombie.rendering;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import redzombie.game.Game;
import redzombie.game.items.AbstractItem;
import redzombie.game.items.AbstractWeapon;
import redzombie.game.items.StackableItem;
import redzombie.game.level.Tile;
import redzombie.util.Util;

public class Renderer extends AbstractRenderer {
    
    Screen screen;
    Terminal terminal;
    
    public Renderer(Screen screen, Terminal terminal) {
        this.screen = screen;
        this.terminal = terminal;
    }
    
    @Override
    public void render(Game g) {
        switch(g.getCurrentState()) {
            case STATE_LEVEL:
                drawLevel(g);
                break;
            case STATE_INVENTORY:
                drawInventory(g);
                break;
        }
    }
    
    private void drawLevel(Game g) {
        screen.clear();
        
        drawLOS(g);
        
        // DRAW PLAYER
        screen.putString(
                g.getPlayer().getPosition().x,
                g.getPlayer().getPosition().y, 
                g.getPlayer().getSymbol(), 
                g.getPlayer().getColor(), 
                Terminal.Color.BLACK);
        
        drawStatistics(g);
        
        screen.refresh();
    }
    
    private void drawLOS(Game g) {
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
                                i, j,
                                t.getDisplayedSymbol(),
                                t.getDisplayedColor(),
                                Terminal.Color.BLACK);
                    }
                }
            }
        }
    }
    
    private void drawStatistics(Game g) {
        g.getScreen().putString(
                0, 26,
                "Health: " + g.getPlayer().getCurrentHealth() + " / " + g.getPlayer().getMaxHealth(),
                Terminal.Color.RED,
                Terminal.Color.BLACK);
    }
    
    private void drawInventory(Game g) {
        screen.clear();
        
        int y = 5;
        int index = 1;
        
        for (AbstractItem i: g.getPlayer().getInventory()) {
            StringBuilder sb = new StringBuilder();
            sb.append(index).append("\t").append(i.getName());
            
            if (i instanceof StackableItem) {
                StackableItem stackable = (StackableItem)i;
                sb.append("\t");
                sb.append("(").append(stackable.getCount()).append(")");
                
            }
            
            if (i instanceof AbstractWeapon) {
                AbstractWeapon w = (AbstractWeapon)i;
                sb.append("\t");
                sb.append(w.getDamageRoll());
            }
            
            screen.putString(5, y, sb.toString(), Terminal.Color.WHITE, Terminal.Color.BLACK);
            
            y++;
            index++;
        }
        
        screen.refresh();
    }
}