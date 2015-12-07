package redzombie.game.items;

import java.util.List;
import redzombie.util.Vec2;

/**
 * Square area of effect implementation.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       4.12.2015
 */
public class SquareAOE extends AreaOfEffect {

    public SquareAOE(Vec2 position) {
        super(position);
    }

    @Override
    public List<Vec2> getArea() {
        return null; // TODO: method stub
    }
}
