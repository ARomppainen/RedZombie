package redzombie.util;

import java.util.ArrayList;
import java.util.List;
import redzombie.game.level.AbstractGameObject;
import redzombie.game.level.Level;

/**
 * Abstract class containing many (static) utility methods.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public abstract class Util {
    
    //rosettacode.org/wiki/Bitmap/Bresenham's_line_algorithm#Java
    public static boolean lineOfSight(Level level, int x1, int y1, int x2, int y2) {
    // delta of exact value and rounded value of the dependant variable
        int d = 0;

        int dy = Math.abs(y2 - y1);
        int dx = Math.abs(x2 - x1);

        int dy2 = (dy << 1); // slope scaling factors to avoid floating
        int dx2 = (dx << 1); // point

        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
        
        if (dy <= dx) {
            for (;;) {
                if (x1 < 0 || x1 >= Level.WIDTH || y1 < 0 || y1 >= Level.HEIGHT) {
                    return false; // out of bounds
                }
                
                
                if (!level.tiles.get(y1).get(x1).isPassable()) {
                    if (x1 != x2) {
                        return false;
                    }
                }
                
                if (x1 == x2) {
                    break;
                }
                x1 += ix;
                d += dy2;
                if (d > dx) {
                    y1 += iy;
                    d -= dx2;
                }
            }
        } else {
            for (;;) {
                if (x1 < 0 || x1 >= Level.WIDTH || y1 < 0 || y1 >= Level.HEIGHT) {
                    return false; // out of bounds
                }
                
                
                if (!level.tiles.get(y1).get(x1).isPassable()) {
                    if (y1 != y2) {
                        return false;
                    }
                }
                
                if (y1 == y2) {
                    break;
                }

                y1 += iy;
                d += dx2;

                if (d > dy) {
                    x1 += ix;
                    d -= dy2;
                }
            }
        }
    
        return true;
    }
    
    public static List<Vec2> getLine(int x1, int y1, int x2, int y2) {
        List<Vec2> points = new ArrayList<>();
        
        // delta of exact value and rounded value of the dependant variable
        int d = 0;

        int dy = Math.abs(y2 - y1);
        int dx = Math.abs(x2 - x1);

        int dy2 = (dy << 1); // slope scaling factors to avoid floating
        int dx2 = (dx << 1); // point

        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
        
        if (dy <= dx) {
            for (;;) {
                if (x1 < 0 || x1 >= Level.WIDTH || y1 < 0 || y1 >= Level.HEIGHT) {
                    break;
                }
                
                points.add(new Vec2(x1, y1));
                
                if (x1 == x2) {
                    break;
                }
                
                x1 += ix;
                d += dy2;
                
                if (d > dx) {
                    y1 += iy;
                    d -= dx2;
                }
            }
        } else {
            for (;;) {
                if (x1 < 0 || x1 >= Level.WIDTH || y1 < 0 || y1 >= Level.HEIGHT) {
                    break;
                }
                
                points.add(new Vec2(x1, y1));
                
                if (y1 == y2) {
                    break;
                }

                y1 += iy;
                d += dx2;

                if (d > dy) {
                    x1 += ix;
                    d -= dy2;
                }
            }
        }
    
        return points;
    }
    
    public static List<AbstractGameObject> findObjectsNextTo(Level l, int x, int y) {
        List<AbstractGameObject> objs = new ArrayList<>();
        
        for (Direction d: Direction.values()) {
            Vec2 pos = newPos(x, y, d);
            
            if (Level.checkBounds(pos) && l.getTile(pos).obj != null) {
                objs.add(l.getTile(pos).obj);
            }
        }
        
        return objs;
    }
    
    public static List<AbstractGameObject> findObjectsNextTo(Level l, Vec2 pos) {
        return findObjectsNextTo(l, pos.x, pos.y);
    }
    
    public static Vec2 up (int x, int y) {
        return new Vec2(x, y - 1);
    }
    
    public static Vec2 up(Vec2 v) {
        return up(v.x, v.y);
    }
    
    public static Vec2 down(int x, int y) {
        return new Vec2(x, y + 1);
    }
    
    public static Vec2 down(Vec2 v) {
        return down(v.x, v.y);
    }
    
    public static Vec2 left(int x, int y) {
        return new Vec2(x - 1, y);
    }
    
    public static Vec2 left(Vec2 v) {
        return left(v.x, v.y);
    }
    
    public static Vec2 right(int x, int y) {
        return new Vec2(x + 1, y);
    }
    
    public static Vec2 right(Vec2 v) {
        return right(v.x, v.y);
    }
    
    public static Vec2 newPos(int x, int y, Direction d) {
        Vec2 position = new Vec2(x, y);
        
        switch (d) {
            case UP:    position.add(0, -1);    break;
            case DOWN:  position.add(0, 1);     break;
            case LEFT:  position.add(-1, 0);    break;
            case RIGHT: position.add(1, 0);     break;
        }
        
        return position;
    }
    
    public static Vec2 newPos(Vec2 v, Direction d) {
        return newPos(v.x, v.y, d);
    }
    
    public static int lerp(int v0, int v1, float t) {
        return (int)((1.0f - t) * v0) + (int)(t * v1); 
    }
    
    public static float lerp(float v0, float v1, float t) {
        return (1.0f - t) * v0 + t * v1;
    }
    
    public static float distance(Vec2 p1, Vec2 p2) {
        // vector from p1 to p2
        Vec2 v = new Vec2(p2.x - p1.x, p2.y - p1.y);
        
        return (float)Math.sqrt(v.x * v.x + v.y * v.y);
    }
}