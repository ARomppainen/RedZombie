package redzombie.game.state;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal.Color;
import redzombie.game.Game;
import redzombie.game.items.AreaOfEffect;
import redzombie.game.level.Level;
import redzombie.game.Renderer;
import redzombie.game.animation.Explosion;
import redzombie.game.animation.LineAnim;
import redzombie.util.Util;
import redzombie.util.Vec2;

/**
 * The state which displays the player, level, targeting line and area of effect.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       4.12.2015
 */
public class TargetingState extends AbstractGameState {

    private Vec2 origin;
    private Vec2 target;
    
    private AreaOfEffect aoe;
    
    public TargetingState(Game g, AreaOfEffect aoe) {
        super(g);
        
        origin = new Vec2(g.getPlayer().getPosition());
        target = new Vec2(origin);
        
        this.aoe = aoe;
    }

    @Override
    public boolean update() {
        Key k = game.getScreen().readInput();
        
        Vec2 newPos = null;
        
        if (k != null ) {
            if (k.getKind() == Key.Kind.Escape) {
                return true;
            }
            
            if (k.getKind() == Key.Kind.ArrowDown) {
                newPos = Util.down(target);
            } else if (k.getKind() == Key.Kind.ArrowLeft) {
                newPos = Util.left(target);
            } else if (k.getKind() == Key.Kind.ArrowRight) {
                newPos = Util.right(target);
            } else if (k.getKind() == Key.Kind.ArrowUp) {
                newPos = Util.up(target);
            } else if (k.getCharacter() == 't' || k.getCharacter() == 'T') {
                AnimationState as = new AnimationState(game);
                as.addAnimation(new LineAnim(500, 0, origin, target, "*", Color.RED));
                as.addAnimation(new Explosion(2000, 500, target, 10.0f, "*", Color.RED));
                
                game.popState();
                game.pushState(as);
            }
            
            if (newPos != null && Level.checkBounds(newPos)) {
                target.set(newPos);
                
                if (aoe != null) {
                    aoe.reposition(newPos);
                }
            }
        }
        
        return false;
    }
    
    public Vec2 getOrigin() {
        return origin;
    }
    
    public Vec2 getTarget() {
        return target;
    }
    
    public AreaOfEffect getAOE() {
        return aoe;
    }

    @Override
    public void render() {
        Renderer.setBackground(aoe, Color.CYAN);
        Renderer.drawLOS(game);
        Renderer.drawStatistics(game);
        Renderer.drawLine(origin, target, "x", "X");
        Renderer.drawPlayer(game.getPlayer());
        
        Renderer.putStringDebug(new Vec2(81, 0), "Debug:", Color.WHITE);
        Renderer.putStringDebug(new Vec2(81, 1), "TargetingState", Color.WHITE);
        Renderer.putStringDebug(new Vec2(81, 2), "DeltaTime: " + Long.toString(game.getDeltaTime()), Color.WHITE);
    }
}
