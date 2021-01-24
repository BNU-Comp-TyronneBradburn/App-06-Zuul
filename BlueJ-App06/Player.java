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
    private int score;
    private int count;
    private int health;
    private ArrayList<Items> itemList;
    private String name;
     
    /**
     * Method to allow the user to control the Character.
     */
    public Player(String name)
    {
        score = 0;
        count = 0;
        health = 100;
 
        itemList = new ArrayList();

        this.name = name;
    }

    /**
     * Method to pick-up Items 
     */
    public void pickUpItem(Items item)
    {
        itemList.add(item);
    }

    /**
     * Method to drop Items when used
     */
    public boolean drop(Items item)
    {
        return itemList.remove(item);
    }

    public int getHealth()
    {
        return health;
    }
    
    public int getScore()
    {
        return score;
    }//end method getHealth

    /**GET Method Propertie itemList*/
    public ArrayList getItemList()
    {
         return this.itemList;
    }//end method getItemList
     
    public int getCount()
    {
        return count;
    }
    
    public void resetScore()
    {
        score = 0;
    }
    
    public void increaseScore(int amount)
    {
        if(amount >= 0)
        score += amount;
    }
    
    public void getHealth(int amount)
    {
        if(amount <= 100)
        health -= amount;
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
