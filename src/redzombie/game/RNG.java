package redzombie.game;

import java.util.Random;

/**
 * A singleton random number generator.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class RNG {
    
    private static RNG instance;
    private final Random rand;
    
    private RNG() {
        rand = new Random();
    }
    
    /**
     * @return The singleton instance.
     */
    public static RNG instance() {
        if (instance == null) {
            instance = new RNG();
        }
        
        return instance;
    }
    
    /**
     * Generates and returns a random integer between [min, max].
     * 
     * @param min The minimum value.
     * @param max The maximum value.
     * @return The generated random number between [min, max].
     */
    public int genInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
    
    /**
     * Generates and returns a random number based on a dice roll.
     * 
     * @param roll The dice to be rolled.
     * @return A random number based on the dice roll.
     */
    public int genInt(DiceRoll roll) {
        int total = roll.offset;
        
        for (int i = 0; i < roll.times; ++i) {
            total += genInt(roll.min, roll.max);
        }
        
        return total;
    }
}