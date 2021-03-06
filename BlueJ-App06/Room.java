import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Tyronne
 * @version 09/12/2020
 * 
 * Modified and extended by Tyronne
 */

public class Room 
{
    private String description;
    private String title;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private String name; 
    private Items item;
    

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    { 
        this.name = description;
        item = Items.NONE;
        description = " ";
        exits = new HashMap<>();
    }
    

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return name;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String message = "You are " + name +  " " + description + ".\n" + getExitString();
        message = message + " Items Found " + item; 
        return message;
    }
    
    
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public void setDescription(String description)
    {
        this.description = description; 
    }
    
    public void addItem(Items item)
    {
        this.item = item;
    }
    
    public Items takeItem()
    {
        Items oldItem = item;
        item = Items.NONE;
        return oldItem;
    }
    
    public String getItem()
    {
        return item.name().toLowerCase();
    }
    
    
}

