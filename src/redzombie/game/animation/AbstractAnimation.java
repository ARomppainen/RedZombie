package redzombie.game.animation;

/**
 * The state which is used to draw animations and block all user input.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       17.12.2015
 */
public abstract class AbstractAnimation {
    
    private long duration;
    private long elapsed;
    private long start;
    
    protected AbstractAnimation(long duration) {
        this.duration = duration;
        this.elapsed = 0;
        this.start = 0;
    }
    
    protected AbstractAnimation(long duration, long start) {
        this.duration = duration;
        this.elapsed = 0;
        this.start = start;
    }
    
    public void update(long deltaTime) {
        elapsed += deltaTime;
    }
    
    public long getDuration() {
        return duration;
    }
    
    public long getElapsed() {
        return elapsed;
    }
    
    public long getStart() {
        return start;
    }
    
    public long getPlayed() {
        return elapsed - start;
    }
    
    public boolean isOver() {
        return getPlayed() > duration;
    }
    
    public float getRelativeTime() {
        float t1 = getPlayed();
        float t2 = duration;
        return t1 / t2;
    }
    
    public abstract void render();
}
