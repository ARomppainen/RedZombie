package redzombie.game.items;

/**
 * The base class for ranged weapons (pistols, rifles, throwing knives etc.)
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public interface AbstractRangedWeapon extends AbstractWeapon {
    public double getRange();
    public AreaOfEffect getAOE();
}
