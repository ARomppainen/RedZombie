package redzombie.game.animation;

import com.googlecode.lanterna.terminal.Terminal.Color;
import java.util.HashSet;
import java.util.Set;
import redzombie.game.Renderer;
import redzombie.game.items.CircleAOE;
import redzombie.util.Util;
import redzombie.util.Vec2;

/**
 * Circular explosion animation.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       17.12.2015
 */
public class Explosion extends AbstractAnimation {

    private Set<Vec2> points;
    private Set<Vec2> area;
    
    private Vec2 origin;
    private float radius;
    private String icon;
    private Color color;
    
    /**
     * 
     * @param duration  animation duration in milliseconds
     * @param delay     delay before animation starts in milliseconds
     * @param origin    the point of origin for the explosion
     * @param radius    the radius of the explosion
     * @param icon      icon used to render the explosion
     * @param color     color used to render the explosion
     */
    public Explosion(long duration, long delay, Vec2 origin, float radius, String icon, Color color) {
        super(duration, delay);
        
        points = new HashSet<>();
        points.add(origin);
        
        area = new CircleAOE(origin, radius).getArea();
        area.remove(origin);
        
        this.origin = new Vec2(origin);
        this.radius = radius;
        this.icon = icon;
        this.color = color;
    }
    
    @Override
    public void update(long deltaTime) {
        super.update(deltaTime);
        
        float played = getPlayed();
        float duration = getDuration();
        
        if (played > 0) {
            float rad = Util.lerp(0.0f, radius, played / duration);
            
            Set<Vec2> newPoints = new HashSet<>();
            
            for (Vec2 v: area) {
                if (Util.distance(origin, v) <= rad) {
                    points.add(v);
                    newPoints.add(v);
                }
            }
            
            area.removeAll(newPoints);
        }
    }
    
    @Override
    public void render() {
        if (getPlayed() > 0) {
            for (Vec2 v: points) {
                Renderer.putString(v, icon, color);
            }
        }
    }
}