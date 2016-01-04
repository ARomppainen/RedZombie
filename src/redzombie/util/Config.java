package redzombie.util;

/**
 * Contains multiple configuration variables.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       4.12.2015
 */
public abstract class Config {
    public static boolean DEBUG = true;
    public static boolean LIMIT_FPS = true;
    public static final int TARGET_FRAME_MS = 10;
    public static final int MAX_FRAME_MS = 100;
}
