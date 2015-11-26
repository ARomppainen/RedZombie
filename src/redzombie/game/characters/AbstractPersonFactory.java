package redzombie.game.characters;

public interface AbstractPersonFactory {
    public AbstractPerson createPlayer();
    public AbstractPerson createMonster();
}
