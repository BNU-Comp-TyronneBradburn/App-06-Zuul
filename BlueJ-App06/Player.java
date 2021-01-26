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
    private int maxHealth;
    private int lost;
    private ArrayList<Items> itemList;
    private String name;
     
    /**
     * Method to allow the user to control the Character.
     */
    public Player(String name)
    {
        score = 0;
        count = 0;
        lost = 0;
        maxHealth = 100;
        
        itemList = new ArrayList();

        this.name = name;
    }

    /**
     * Method to pick-up Items and add a score value to the items.
     */
    public void takeItem(Items item)
    {
        itemList.add(item);
        if(item == Items.BOTTLE)
        {
            score = score + 10;
            
        }
        else if(item == Items.CHALICE)
        {
            score = score + 10;
        }
        else if(item == Items.SWORD)
        {
            score = score + 10;
        }
        else if(item == Items.GOLDBARS)
        {
            score = score + 10;
        }
        else if(item == Items.SHIELD)
        {
            score = score + 10;
        }
        else if(item == Items.RUBY)
        {
            score = score + 10;
        }
        else if(item == Items.ARMOUR)
        {
            score = score + 10;
        }
        else if(item == Items.DIAMOND)
        {
            score = score + 10;
        }
        else if(item == Items.BAGOFCOINS)
        {
            score = score + 10;
        }
    }
    
    
    /**
     * Method to drop Items when used
     */
    public boolean drop(Items item)
    {
        return itemList.remove(item);
    }
    
    /**
     * Method to return the health. 
     */
    public int maxHealth()
    {
        return maxHealth;
    }
    
    public int getScore()
    {
        return score;
    }
    
    /**GET Method Propertie itemList*/
    public ArrayList getItemList()
     {
         return this.itemList;
    }//end method getItemList

    /**
     * Method to increase the current score
     */
    public void increaseScore(int amount)
    {
        this.score = score + amount;
    }
    
    /**
     *  Method to set the max health
     */
     public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }
  
    
    /**
     * method to print the stats of the player
     */
    public void printStats()
    {
        System.out.println("Player Stats. ");
        System.out.println("Score =  " + score);
        System.out.println("Health = " + maxHealth);
        
    }
    
    /**
     *  method to maske sure the player has the item for the cell unlock
     */
    public boolean hasItem(Items targetItem)
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
