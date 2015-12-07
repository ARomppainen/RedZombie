package redzombie.game.state;

import com.googlecode.lanterna.input.Key;
import redzombie.game.Game;
import redzombie.game.items.AreaOfEffect;
import redzombie.game.level.Level;
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
    public GameState getType() {
        return GameState.STATE_TARGETING;
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
                // TODO: throw the item
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
}
