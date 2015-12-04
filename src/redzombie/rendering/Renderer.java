package redzombie.rendering;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import redzombie.game.Game;
import redzombie.game.characters.AbstractPerson;
import redzombie.game.items.AbstractInventory;
import redzombie.game.items.AbstractItem;
import redzombie.game.items.AbstractWeapon;
import redzombie.game.items.AreaOfEffect;
import redzombie.game.items.StackableItem;
import redzombie.game.level.Tile;
import redzombie.game.state.TargetingState;
import redzombie.util.Util;
import redzombie.util.Vec2;

/**
 * Renderer implementation.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class Renderer implements AbstractRenderer {
    
    private Screen screen;
    private Terminal terminal;
    
    private Set<Vec2> background;
    private Color backgroundColor;
    
    public Renderer(Screen screen, Terminal terminal) {
        this.screen = screen;
        this.terminal = terminal;
        
        background = null;
        backgroundColor = Color.BLACK;
    }
    
    @Override
    public void render(Game g) {
        switch(g.getGameState().getType()) {
            case STATE_LEVEL:
                drawLevelState(g);
                break;
            case STATE_INVENTORY:
                drawInventoryState(g);
                break;
            case STATE_TARGETING:
                drawTargetingState(g);
                break;
        }
    }
    
    private void drawLevelState(Game g) {
        screen.clear();
        
        resetBackground();
        drawLOS(g);
        drawPlayer(g.getPlayer());
        drawStatistics(g);
        
        screen.refresh();
    }
    
    private void drawInventoryState(Game g) {
        screen.clear();

        resetBackground();
        drawInventory(g.getPlayer().getInventory());
        
        screen.refresh();
    }
    
    private void drawTargetingState(Game g) {
        screen.clear();
        
        TargetingState ts = (TargetingState)g.getGameState();
        
        setBackground(ts.getAOE(), Color.CYAN);
        drawLOS(g);
        drawStatistics(g);
        drawLine(ts.getOrigin(), ts.getTarget());
        
        drawPlayer(g.getPlayer());
        
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
                        
                        /*
                        screen.putString(
                                i, j,
                                t.getDisplayedSymbol(),
                                t.getDisplayedColor(),
                                Terminal.Color.BLACK);
                        */
                        
                        putString(new Vec2(i, j), t.getDisplayedSymbol(), t.getDisplayedColor());
                    }
                }
            }
        }
    }
    
    private void drawPlayer(AbstractPerson player) {
        /*
        screen.putString(
                player.getPosition().x,
                player.getPosition().y, 
                player.getSymbol(), 
                player.getColor(), 
                Terminal.Color.BLACK);
        */
        
        putString(player.getPosition(), player.getSymbol(), player.getColor());
    }
    
    private void drawStatistics(Game g) {
        screen.putString(
                0, 26,
                "Health: " + g.getPlayer().getCurrentHealth() + " / " + g.getPlayer().getMaxHealth(),
                Terminal.Color.RED,
                Terminal.Color.BLACK);
    }
    
    private void drawInventory(AbstractInventory<AbstractItem> inv) {
        int y = 5;
        int index = 1;
        
        for (AbstractItem i: inv) {
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
            
            //screen.putString(5, y, sb.toString(), Terminal.Color.WHITE, Terminal.Color.BLACK);
            putString(new Vec2(5, y), sb.toString(), Color.WHITE);
            
            y++;
            index++;
        }
    }
    
    private void drawLine(Vec2 from, Vec2 to) {
        List<Vec2> line;
        
        if (from.equals(to)) {
            line = new ArrayList<>();
            line.add(from);
        } else {
            line = Util.getLine(from.x, from.y, to.x, to.y);
        }
        
        line.stream().forEach((v) -> {
            //screen.putString(v.x, v.y, "x", Terminal.Color.YELLOW, Terminal.Color.BLACK);
            putString(v, "x", Color.YELLOW);
        });
        
        Vec2 last = line.get(line.size() - 1);
        //screen.putString(last.x, last.y, "X", Terminal.Color.YELLOW, Terminal.Color.BLACK);
        putString(last, "X", Color.YELLOW);
    }
    
    private void setBackground(AreaOfEffect aoe, Color color) {
        if (aoe == null) {
            background = null;
            backgroundColor = Color.BLACK;
        } else {
            if (background == null) {
                background = new HashSet<>();
            }
            
            background.clear();
            background.addAll(aoe.getArea());
            backgroundColor = color;
        }
    }
    
    private void resetBackground() {
        background = null;
        backgroundColor = Color.BLACK;
    }
    
    private void putString(Vec2 pos, String text, Color c) {
        if (background != null && background.contains(pos)) {
            screen.putString(pos.x, pos.y, text, c, backgroundColor);
        } else {
            screen.putString(pos.x, pos.y, text, c, Color.BLACK);
        }
    }
}