import java.util.ArrayList;
import java.util.List;
/**
 * The player class allows the user to control the character within the
 * world of Zuul. It also shows the health, energy, attack value and defence
 * value.
 *
 * @author (Tyronne)
 * @version (09/12/2020)
 */
public class Player
{
    private int health; 
    private int energy;
    private ArrayList<Items> itemList;
    //As a percentage between 0-100%
    private int attackValue;
    //As a percentage between 0-100%
    private int defenceValue;
    private String name;

    /**
     * Method to allow the user to control the Character.
     */
    public Player(String name)
    {
        health = 100;
        energy = 100;
        attackValue = 10;
        defenceValue = 10;

        itemList = new ArrayList();

        this.name = name;
    }

    /**
     * Method to pick-up Items 
     */
    public void pickUpItem(Items item)
    {
        itemList.add(item);
        
        if (item == Items.SWORD)
            attackValue = 100;
        
        if (item == Items.SHIELD)
            defenceValue = 100; 
    }

    /**
     * Method to drop Items when used
     */
    public boolean drop(Items item)
    {
        return itemList.remove(item);
    }

    //Start GetterSetterExtension Source Code
    /**GET Method Propertie health*/
    public int getHealth(){
        return this.health;
    }//end method getHealth

    /**SET Method Propertie health*/
    public void changeHealth(int amount)
    {
        this.health = this.health + amount;
    }//end method setHealth

    /**GET Method Propertie energy*/
    public int getEnergy()
    {
        return this.energy;
    }//end method getEnergy

    /**SET Method Propertie energy*/
    public void setEnergy(int energy)
    {
        this.energy = this.energy + energy;
    }//end method setEnergy

    /**GET Method Propertie itemList*/
    public ArrayList getItemList()
    {
        return this.itemList;
    }//end method getItemList

    /**GET Method Propertie attackValue*/
    public int getAttackValue()
    {
        return this.attackValue;
    }//end method getAttackValue

    /**SET Method Propertie attackValue*/
    public void setAttackValue(int attackValue)
    {
        this.attackValue = attackValue;
    }//end method setAttackValue

    /**GET Method Propertie defenceValue*/
    public int getDefenceValue()
    {
        return this.defenceValue;
    }//end method getDefenceValue

    /**SET Method Propertie defenceValue*/
    public void setDefenceValue(int defenceValue)
    {
        this.defenceValue = defenceValue;
    }//end method setDefenceValue

    //End GetterSetterExtension Source Code
    //!
    
    /**
     *  Player can get the status of the charatcer.
     */
    public String getStatus()
    {
        String message = "attack value: " + attackValue + ".\n";
        message = message + " defence value: \t" + defenceValue + ".\n";
        message = message + " health: \t " + health + ".\n";
        return message;
    }
    
    public void printStats()
    {
        System.out.println("Attack: " + attackValue);
        
        System.out.println("health: " + health);
        System.out.println("Energy: " + energy);
    }
    
    /**
     *  method to maske sure the player has the item for the cell unlock
     */
    public boolean isCarrying(Items targetItem)
    {
        boolean found = false; 
        for(Items item: itemList)
        {
            if(item == targetItem) 
            {
                return true;
            }  
        }
        return false;
    }
}
