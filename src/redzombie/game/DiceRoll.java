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