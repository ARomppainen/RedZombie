package redzombie.game.state;

import com.googlecode.lanterna.terminal.Terminal.Color;
import java.util.ArrayList;
import java.util.List;
import redzombie.game.Game;
import redzombie.game.Renderer;
import redzombie.game.animation.AbstractAnimation;
import redzombie.util.Vec2;

/**
 * The state which is used to draw animations and block all user input.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       17.12.2015
 */
public class AnimationState extends AbstractGameState {

    private List<AbstractAnimation> animations;
    
    public AnimationState(Game g) {
        super(g);
        animations = new ArrayList<>();
    }
    
    public void addAnimation(AbstractAnimation a) {
        animations.add(a);
    }

    @Override
    public boolean update() {
        List<AbstractAnimation> remaining = new ArrayList<>();
        
        for (AbstractAnimation a: animations) {
            a.update(game.getDeltaTime());
            
            if (!a.isOver()) {
                remaining.add(a);
            }
        }
        
        animations.clear();
        animations.addAll(remaining);
        
        return animations.isEmpty();
    }

    @Override
    public void render() {
        Renderer.resetBackground();
        Renderer.drawLOS(game);
        
        for (AbstractAnimation a: animations) {
            a.render();
        }
        
        Renderer.drawPlayer(game.getPlayer());
        Renderer.drawStatistics(game);
        
        Renderer.putStringDebug(new Vec2(81, 0), "Debug:", Color.WHITE);
        Renderer.putStringDebug(new Vec2(81, 1), "AnimationState", Color.WHITE);
        Renderer.putStringDebug(new Vec2(81, 2), "DeltaTime: " + Long.toString(game.getDeltaTime()), Color.WHITE);
        Renderer.putString(new Vec2(81, 3), "Animations: " + animations.size(), Color.WHITE);
    }
}
