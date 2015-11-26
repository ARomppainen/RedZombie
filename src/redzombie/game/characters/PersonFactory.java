package redzombie.game.characters;

import redzombie.game.characters.Person;
import com.googlecode.lanterna.terminal.Terminal;

public class PersonFactory implements AbstractPersonFactory {

    private static AbstractPersonFactory instance = null;
    
    private PersonFactory() {
        
    }
    
    public static AbstractPersonFactory instance() {
        if (instance == null) {
            instance = new PersonFactory();
        }
        
        return instance;
    }
    
    @Override
    public AbstractPerson createPlayer() {
        return new Person(0, 0, "@", Terminal.Color.CYAN, 5.5, 10);
    }

    @Override
    public Person createZombie() {
        return new Person(0, 0, "Z", Terminal.Color.WHITE, 3.0, 5);
    }
}