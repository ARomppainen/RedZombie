package redzombie.game.items;

import java.util.ArrayList;
import java.util.List;
import redzombie.util.Vec2;

/**
 * Circular area of effect implementation.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       4.12.2015
 */
public class CircleAOE extends AreaOfEffect {

    private double radius;
    
    /**
     * Creates a new circular area with the given position and radius.
     * 
     * @param position The origin point for the area.
     * @param radius The radius of the circle.
     */
    public CircleAOE(Vec2 position, double radius) {
        super(position);
        
        this.radius = radius;
        
        this.area = null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vec2> getArea() {
        if (area == null) {
            calcArea();
        }
        
        return area;
    }
    
    /**
     * Calculates the list of coordinate points for the area.
     */
    private void calcArea() {
        area = new ArrayList<>();
        
        int minX = position.x - (int)radius;
        int maxX = position.x + (int)radius;
        int minY = position.y - (int)radius;
        int maxY = position.y + (int)radius;
        
        for (int i = minX; i <= maxX; ++i) {
            for (int j = minY; j <= maxY; ++j) {
                int dx = Math.abs(i - position.x);
                int dy = Math.abs(j - position.y);
                double dist = Math.sqrt(dx * dx + dy * dy);
                
                if (dist <= radius) {
                    area.add(new Vec2(i, j));
                }
            }
        }
    }
}