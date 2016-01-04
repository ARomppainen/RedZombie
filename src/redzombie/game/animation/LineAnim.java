package redzombie.game.animation;

import com.googlecode.lanterna.terminal.Terminal.Color;
import java.util.List;
import redzombie.game.Renderer;
import redzombie.util.Util;
import redzombie.util.Vec2;

/**
 * Animation where an object moves in a straight line.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       17.12.2015
 */
public class LineAnim extends AbstractAnimation {

    List<Vec2> line;
    String icon;
    Color color;
    
    public LineAnim(long duration, long delay, Vec2 from, Vec2 to, String icon, Color color) {
        super(duration, delay);
        
        this.line = Util.getLine(from.x, from.y, to.x, to.y);
        this.icon = icon;
        this.color = color;
    }
    
    @Override
    public void render() {
        if (getPlayed() >= 0) {
            int frame = Util.lerp(0, line.size() - 1, getRelativeTime());
            
            Renderer.putString(line.get(frame), icon, color);
        }
    }
}
