
/**
 * The Map class shows the user with they have been.
 *
 * @author (Tyronne)
 * @version (09/12/2020)
 */
public class Map
{
    
    private Room startRoom;
    private Room forest;
    private Room westForest;
    private Room eastForest;
    private Room cave;
    private Room dungeon; 
    
    public Map()
    {
        createFirstRooms();
        connectFirstRooms();
        
        startRoom = forest;
    }
    
    private void createFirstRooms()
    {
        forest = new Room("in a gloomy forest with trees in every direction");
        eastForest = new Room("at an impassable cliff face");
        westForest = new Room("near an impassable river");
        cave = new Room("see an cave entrance");
    }
   
    private void connectFirstRooms()
    {
        forest.setExit("east",eastForest);
        forest.setExit("west",westForest);
        forest.setExit("north", cave);
        
        eastForest.setExit("west", forest);
        westForest.setExit("east", forest);
        westForest.addItem(Items.BOTTLE);
        
        cave.setExit("south", forest);
    }
    
    /**
     * Create all the rooms and link their exits together.
     */
    
    private void createOldRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        startRoom = outside;  // start game outside
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
}
