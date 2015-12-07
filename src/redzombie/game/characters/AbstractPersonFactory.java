package redzombie.game.characters;

/**
 * Abstract factory for character creation.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public interface AbstractPersonFactory {
    public AbstractPerson createPlayer();
    public AbstractPerson createZombie();
}
