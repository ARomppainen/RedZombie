package redzombie.game;

import java.util.Random;

public class RNG {
    
    private static RNG instance;
    private final Random rand;
    
    private RNG() {
        rand = new Random();
    }
    
    public static RNG instance() {
        if (instance == null) {
            instance = new RNG();
        }
        
        return instance;
    }
    
    public int genInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
    
    public int genInt(DiceRoll roll) {
        int total = roll.offset;
        
        for (int i = 0; i < roll.times; ++i) {
            total += genInt(roll.min, roll.max);
        }
        
        return total;
    }
}