package redzombie.game.items;

import java.util.Objects;

/**
 * The base class for collectible items in the game.
 * 
 * @author      Aleksi Romppainen <aromppa@gmail.com>
 * @since       30.11.2015
 */
public abstract class AbstractItem {
    private String name;
    
    protected AbstractItem(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof AbstractItem) {
                AbstractItem i = (AbstractItem)o;
                
                return this.name.equals(i.name);
            }
            
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }
}