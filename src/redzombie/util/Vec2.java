package redzombie.util;

/**
 * Simple 2-dimensional vector class, used mostly to represent coordinate data.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class Vec2 {
    public int x;
    public int y;
    
    public Vec2() {
        x = 0;
        y = 0;
    }
    
    public Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Vec2(Vec2 v) {
        this.x = v.x;
        this.y = v.y;
    }
    
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void set(Vec2 v) {
        set(v.x, v.y);
    }
    
    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }
    
    public void add(Vec2 v) {
        add(v.x, v.y);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Vec2) {
                Vec2 v = (Vec2)o;
                
                if (x == v.x && y == v.y) {
                    return true;
                }
            }
            
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.x;
        hash = 61 * hash + this.y;
        return hash;
    }
}