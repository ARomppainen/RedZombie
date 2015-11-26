package redzombie.util;

import redzombie.game.level.Level;


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

        //boolean wallFound = false;
        //int wallCoord = 0;
        
        if (dy <= dx) {
            for (;;) {
                if (x1 < 0 || x1 >= Level.WIDTH || y1 < 0 || y1 >= Level.HEIGHT) {
                    return false; // out of bounds
                }
                
                
                if (level.tiles.get(y1).get(x1).wall) {
                    if (x1 != x2) {
                        return false;
                    }
                }
                //*/
                
                /*
                if (level.tiles.get(y1).get(x1).wall) {
                    if (!wallFound) {
                        wallFound = true;
                        wallCoord = y1;
                    } else {
                        if (y1 != wallCoord) {
                            return false;
                        }
                    }
                } else if (wallFound) {
                    return false;
                }
                //*/
                
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
                
                
                if (level.tiles.get(y1).get(x1).wall) {
                    if (y1 != y2) {
                        return false;
                    }
                }
                //*/
                
                /*
                if (level.tiles.get(y1).get(x1).wall) {
                    if (!wallFound) {
                        wallFound = true;
                        wallCoord = x1;
                    } else {
                        if (x1 != wallCoord) {
                            return false;
                        }
                    }
                } else if (wallFound) {
                    return false;
                }
                //*/
                
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
}