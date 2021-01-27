import java.util.Scanner;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Tyronne
 * @version 09/12/2020
 * 
 * Modified and extended by Tyronne
 */

public class Game 
{
    private Parser parser;
    private Map map;
    private Room currentRoom;
    private Room dunegonExit; 
    private Player player;
    private Timer timer;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
     {
        map = new Map(); 
        currentRoom = map.getStartRoom();     
        parser = new Parser();
        player = new Player("Tyronne");
        timer = new Timer (30, -1, 5);
    }
    
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.;
        boolean finished = false;
        
        while (! finished) 
        {
            {
                Command command = parser.getCommand();
                finished = processCommand(command);
            }  
        }
        
        if(currentRoom.getLongDescription().equals("dungeonExit"))
        {
            winGame();
            finished = true; 
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * Method to win the game when the player reaches the exit. 
     */
    private void winGame()
    {
        System.out.println("You have collected all the treasure \n for the king,");
        System.out.println("You have won the game.");
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("You have been tasked to reclaim the Kings treasure.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("You have "+ timer +"s to win.");
        System.out.println();
        
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        boolean updateTimer = true;
        
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                updateTimer = false;
                return false;
                
            case HELP:
                printHelp();
                updateTimer = false; 
                break;

            case GO:
                wantToQuit = goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case TAKE:
                takeItem(command);
                break;     
            
            case UNLOCK:
                unlockDoor(command);
                break;
            
            case TIME:
                System.out.println("You have " + timer + "s left...");
                break;
                
        } 
        
        if (updateTimer) 
        {
            timer.updateTimer();
            if (timer.hasExpired()) 
            {
                System.out.println("Time's up - you lost!");
                wantToQuit = true;
            } 
            else if (timer.isLow()) 
            {
                System.out.println("Time is running low!");
                System.out.println("You have " + timer + "s left...");
            }
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are to collect the Kings treasure.");
        System.out.println("You are alone and search rhe forest and dungeon");
        System.out.println("You must leave through the dungeon and return to the King.");
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    
    private boolean goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
           // if there is no second word, we don't know where to go...
           System.out.println("Go where?");
           return false;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println("There is no door!");
        }
        else  
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
        return false;
    }
    
    
    
    /**
     * method to unlock the cell door
     */
    public boolean unlockDoor(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Unlock which exit?");
            return false;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println("There is no door!");
        }
        else 
        {
            if(nextRoom.getShortDescription().contains("coin"))
            {
                if(player.isCarrying(Items.KEY))
                {
                    currentRoom = nextRoom;
                    System.out.println("You have opened the door with the key.");
                    System.out.println(currentRoom.getLongDescription());
                }
                else
                {
                    System.out.println("You need a key to open this door.");
                }
            }
            else
            {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        return false;
    }
     
    
    
    /**
      * method to take items from rooms.
     */
    private void takeItem(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("What Item?");
            return;
        }

        String itemString = command.getSecondWord();

        // Try to leave current room.

        String roomItem = currentRoom.getItem();
        if (itemString.equals(roomItem))
        {
            System.out.println(" item " + itemString + " taken " );
            currentRoom.takeItem();
            Items item = Items.valueOf(itemString.toUpperCase());
            player.takeItem(item);
            printStats();
        }
        else 
        {
            System.out.println(" Item not avaiable ");
        } 
    }
    
    public void printStats()
    {
        player.printStats();
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("Quit what?");
            return false;
        }
        else 
        {
            return true;  // signal that we want to quit
        }
    }
    
}