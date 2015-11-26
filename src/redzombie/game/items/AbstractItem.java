package redzombie.game.items;

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
}