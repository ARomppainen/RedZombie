package redzombie.game;

/**
 * This class represents a dice roll which are commonly used in pen & paper
 * role-playing games.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public class DiceRoll {
    public int times;
    public int min;
    public int max;
    public int offset;
    
    /**
     * A dice that is rolled a single time with minimum value of 1.
     * 
     * @param range The maximum number the dice can roll.
     */
    public DiceRoll(int range) {
        this.times = 1;
        this.min = 1;
        this.max = range;
        this.offset = 0;
    }
    
    /**
     * A dice that is rolled n times with minimum value of 1.
     * 
     * @param times The number of times the dice is rolled.
     * @param range The maximum number the dice can roll (minimum is 1).
     */
    public DiceRoll(int times, int range) {
        this.times = times;
        this.min = 1;
        this.max = range;
        this.offset = 0;
    }
    
    /**
     * A dice that is rolled n times with offset.
     * 
     * @param times The number of times the dice is rolled.
     * @param range The maximum number the dice can roll (minimum is 1).
     * @param offset This value is added to the total dice roll.
     */
    public DiceRoll(int times, int range, int offset) {
        this.times = times;
        this.min = 1;
        this.max = range;
        this.offset = offset;
    }
    
    /**
     * A dice that is rolled n times with offset.
     * 
     * @param times The number of times the dice is rolled.
     * @param min The minimum number the dice can roll.
     * @param max The maximum number the dice can roll.
     * @param offset This value is added to the total dice roll.
     */
    public DiceRoll(int times, int min, int max, int offset) {
        this.times = times;
        this.min = min;
        this.max = max;
        this.offset = offset;
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        if (times > 1) {
            sb.append(times).append(" * ");
        }
        
        sb.append("(");
        sb.append(min).append("-").append(max);
        sb.append(")");
        
        if (offset > 0) {
            sb.append(" + ").append(" ").append(offset);
        } else if (offset < 0) {
            sb.append(" - ").append(" ").append(offset);
        }
        
        return sb.toString();
    }
}