package redzombie.game.items;

import redzombie.game.DiceRoll;

/**
 * This class represents (stackable) ammunition used by ranged weapons.
 * 
 * @author  Aleksi Romppainen <aromppa@gmail.com>
 * @version 0.1
 * @since 30.11.2015
 */
public class Ammo extends StackableItem {
    
    private DiceRoll damageRoll;
    private AmmoType type;
    private AreaOfEffect aoe;
    
    public Ammo(String name, DiceRoll damageRoll, int count, AmmoType type) {
        super(name, count);
        
        this.damageRoll = damageRoll;
        this.type = type;
        this.aoe = null;
    }
    
    public Ammo(String name, DiceRoll damageRoll, int count, AmmoType type, AreaOfEffect aoe) {
        super(name, count);
        
        this.damageRoll = damageRoll;
        this.type = type;
        this.aoe = aoe;
    }
    
    public DiceRoll getDamageRoll() {
        return damageRoll;
    }
    
    public AmmoType getType() {
        return type;
    }
    
    public AreaOfEffect getAOE() {
        return aoe;
    }
}