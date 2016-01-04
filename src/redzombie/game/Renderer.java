package redzombie.game;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import redzombie.game.characters.AbstractPerson;
import redzombie.game.items.AbstractInventory;
import redzombie.game.items.AbstractItem;
import redzombie.game.items.AbstractWeapon;
import redzombie.game.items.AreaOfEffect;
import redzombie.game.items.StackableItem;
import redzombie.game.level.Tile;
import redzombie.util.Config;
import redzombie.util.Util;
import redzombie.util.Vec2;

/**
 * Renderer implementation.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class Renderer {
    
    private static Screen screen;
    private static Set<Vec2> background;
    private static Color backgroundColor;
    
    public Renderer(Screen screen) {
        Renderer.screen = screen;
        Renderer.background = null;
        Renderer.backgroundColor = Color.BLACK;
    }
    
    public void render(Game g) {
        screen.clear();
        
        g.getGameState().render();
        
        screen.refresh();
    }
    
    public static void drawLOS(Game g) {
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
                        putString(new Vec2(i, j), t.getDisplayedSymbol(), t.getDisplayedColor());
                    }
                }
            }
        }
    }
    
    public static void drawPlayer(AbstractPerson player) {
        putString(player.getPosition(), player.getSymbol(), player.getColor());
    }
    
    public static void drawStatistics(Game g) {
        screen.putString(
                0, 26,
                "Health: " + g.getPlayer().getCurrentHealth() + " / " + g.getPlayer().getMaxHealth(),
                Terminal.Color.RED,
                Terminal.Color.BLACK);
    }
    
    public static void drawInventory(AbstractInventory<AbstractItem> inv) {
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
            
            putString(new Vec2(5, y), sb.toString(), Color.WHITE);
            
            y++;
            index++;
        }
    }
    
    public static void drawLine(Vec2 from, Vec2 to, String lineChar, String targetChar) {
        List<Vec2> line;
        
        if (from.equals(to)) {
            line = new ArrayList<>();
            line.add(from);
        } else {
            line = Util.getLine(from.x, from.y, to.x, to.y);
        }
        
        line.stream().forEach((v) -> {
            putString(v, lineChar, Color.YELLOW);
        });
        
        Vec2 last = line.get(line.size() - 1);
        putString(last, targetChar, Color.YELLOW);
    }
    
    public static void setBackground(AreaOfEffect aoe, Color color) {
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
    
    public static void resetBackground() {
        background = null;
        backgroundColor = Color.BLACK;
    }
    
    public static void putString(Vec2 pos, String text, Color c) {
        if (background != null && background.contains(pos)) {
            screen.putString(pos.x, pos.y, text, c, backgroundColor);
        } else {
            screen.putString(pos.x, pos.y, text, c, Color.BLACK);
        }
    }
    
    public static void putStringDebug(Vec2 pos, String text, Color c) {
        if (Config.DEBUG) {
            if (background != null && background.contains(pos)) {
            screen.putString(pos.x, pos.y, text, c, backgroundColor);
            } else {
                screen.putString(pos.x, pos.y, text, c, Color.BLACK);
            }
        }
    }
}