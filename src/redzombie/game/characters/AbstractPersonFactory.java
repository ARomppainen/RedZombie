package redzombie.game.characters;

/**
 * Abstract factory for character creation.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public interface AbstractPersonFactory {
    public AbstractPerson createPlayer();
    public AbstractPerson createZombie();
}
