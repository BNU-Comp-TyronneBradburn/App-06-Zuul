
/**
 * The Map class shows the user with they have been.
 *
 * @author (Tyronne)
 * @version (09/12/2020)
 */
public class Map
{
    private Room room;
    private Room startRoom;
    private Room currentRoom;
    private Room forest;
    private Room westForest;
    private Room eastForest;
    private Room caveEntrance;
    private Room caveRoom;
    private Room dungeonSouthernCorridor;
    private Room dungeonNorthernCorridor;
    private Room dungeonRoom;
    private Room dungeonKeyRoom;
    private Room dungeonTrapRoom;
    private Room dungeonCellRoom;
    
    /**
     * Method for the starting point of the game
     */
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
        caveEntrance = new Room("at an cave entrance");
        caveRoom = new Room("in a large cave room");
        dungeonSouthernCorridor = new Room("in what appears to be a dungeon Corridor");
        dungeonNorthernCorridor = new Room("in the northern part of the dungeon");
        dungeonRoom = new Room("in dungeon room");
        dungeonKeyRoom = new Room("in a dungeon room");
        dungeonTrapRoom = new Room("in a dungeon room and step on a trap plate and activate a trap");
        dungeonCellRoom = new Room("in a what appears to be a cell room and managed to free the girl");
    }
   
    /**
     * Method to connect the rooms. 
     */
    private void connectFirstRooms()
    {
        forest.setExit("east",eastForest);
        forest.setExit("west",westForest);
        forest.setExit("north", caveEntrance);
        
        eastForest.setExit("west", forest);
        westForest.setExit("east", forest);
        westForest.addItem(Items.BOTTLE);
        
        caveEntrance.setExit("north", caveRoom);
        caveEntrance.setExit("south", forest);
        
        caveRoom.setExit("north", dungeonSouthernCorridor);
        caveRoom.setExit("south", caveEntrance);
        
        dungeonSouthernCorridor.setExit("north", dungeonNorthernCorridor);
        dungeonSouthernCorridor.setExit("east", dungeonRoom);
        dungeonSouthernCorridor.setExit("south", caveRoom);
        dungeonSouthernCorridor.setExit("west", dungeonTrapRoom);
        dungeonSouthernCorridor.addItem(Items.SWORD);
        
        dungeonRoom.setExit("west", dungeonSouthernCorridor);
        dungeonRoom.addItem(Items.SHIELD);
        
        dungeonTrapRoom.setExit("east", dungeonSouthernCorridor);
        
        dungeonNorthernCorridor.setExit("north", dungeonCellRoom);
        dungeonNorthernCorridor.setExit("south", dungeonSouthernCorridor);
        dungeonNorthernCorridor.setExit("east", dungeonKeyRoom);
        dungeonNorthernCorridor.setExit("west", dungeonTrapRoom);
        
        dungeonKeyRoom.setExit("west", dungeonNorthernCorridor);
        dungeonKeyRoom.addItem(Items.KEY);
        
        dungeonTrapRoom.setExit("east", dungeonNorthernCorridor);
        
        dungeonCellRoom.setExit("south", dungeonNorthernCorridor);   
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
    
    public Room currentRoom()
    {
        return currentRoom;
    }
}
