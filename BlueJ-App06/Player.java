import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private int health; 
    private int energy;
    private ArrayList itemList;
    private int attackValue;
    private int defenceValue;
    private String name;
    
    public Player(String name)
    {
        health = 100;
        energy = 100;
        attackValue = 0;
        defenceValue = 0;
        
        itemList = new ArrayList();
        
        this.name = name;
    }
    
    
    
    public void pickUp(Items item)
    {
        itemList.add(item);
    }
    
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
    public void changeHealth(int amount){
        this.health = this.health + amount;
    }//end method setHealth

    /**GET Method Propertie energy*/
    public int getEnergy(){
        return this.energy;
    }//end method getEnergy

    /**SET Method Propertie energy*/
    public void setEnergy(int energy){
        this.energy = energy;
    }//end method setEnergy

    /**GET Method Propertie itemList*/
    public ArrayList getItemList(){
        return this.itemList;
    }//end method getItemList

    /**GET Method Propertie attackValue*/
    public int getAttackValue(){
        return this.attackValue;
    }//end method getAttackValue

    /**SET Method Propertie attackValue*/
    public void setAttackValue(int attackValue){
        this.attackValue = attackValue;
    }//end method setAttackValue

    /**GET Method Propertie defenceValue*/
    public int getDefenceValue(){
        return this.defenceValue;
    }//end method getDefenceValue

    /**SET Method Propertie defenceValue*/
    public void setDefenceValue(int defenceValue){
        this.defenceValue = defenceValue;
    }//end method setDefenceValue

    //End GetterSetterExtension Source Code
//!
}
