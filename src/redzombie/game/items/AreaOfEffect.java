package redzombie.game.items;

import java.util.Set;
import redzombie.util.Vec2;

/**
 * Base class for effects with an area (explosions etc).
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       4.12.2015
 */
public abstract class AreaOfEffect {
    
    protected Vec2 position;
    protected Set<Vec2> area;
    
    protected AreaOfEffect(Vec2 position) {
        this.position = new Vec2(position);
        this.area = null;
    }
    
    /**
     * @return A list of coordinates according to the type of area of effect.
     */
    public abstract Set<Vec2> getArea();
    
    public void reposition(Vec2 newPos) {
        this.position.set(newPos);
        this.area = null;
    }
    
    public Vec2 getPosition() {
        return position;
    }
}