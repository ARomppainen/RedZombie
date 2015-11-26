package redzombie.game;

public class DiceRoll {
    public int times;
    public int min;
    public int max;
    public int offset;
    
    public DiceRoll(int range) {
        this.times = 1;
        this.min = 1;
        this.max = range;
        this.offset = 0;
    }
    
    public DiceRoll(int times, int range) {
        this.times = times;
        this.min = 1;
        this.max = range;
        this.offset = 0;
    }
    
    public DiceRoll(int times, int range, int offset) {
        this.times = times;
        this.min = 1;
        this.max = range;
        this.offset = offset;
    }
    
    public DiceRoll(int times, int min, int max, int offset) {
        this.times = times;
        this.min = min;
        this.max = max;
        this.offset = offset;
    }
}