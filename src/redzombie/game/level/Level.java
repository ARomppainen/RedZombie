package redzombie.game.level;

import com.googlecode.lanterna.terminal.Terminal;
import java.util.ArrayList;

public class Level {
    public static final int WIDTH = 80;
    public static final int HEIGHT = 25;
    
    public ArrayList<ArrayList<Tile>> tiles;
    
    public Level() {
        tiles = new ArrayList<>();
        
        for (int i = 0; i < HEIGHT; ++i) {
            tiles.add(new ArrayList<>());
            
            for (int j = 0; j < WIDTH; ++j) {
                tiles.get(i).add(new Tile(".", Terminal.Color.WHITE, false, false));
            }
        }
        
        for (int i = 11; i < 20; ++i) {
            tiles.get(11).set(i, new Tile("#", Terminal.Color.RED, true, false));
            tiles.get(12).set(i, new Tile("#", Terminal.Color.RED, true, false));
        }
        
        for (int i = 14; i < 23; ++i) {
            tiles.get(i).set(11, new Tile("#", Terminal.Color.RED, true, false));
            tiles.get(i).set(12, new Tile("#", Terminal.Color.RED, true, false));
        }
    }
    
    public Tile getTile(int x, int y) {
        return tiles.get(y).get(x);
    }
}