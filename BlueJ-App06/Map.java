
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
    private Room dungeonDiamondRoom;
    private Room dungeonCoinRoom;
    private Room dungeonExit;
     
    /**
     * Method for the starting point of the game
     */
    public Map()
    {
        createRooms();
        connectRooms();
        
        startRoom = dungeonKeyRoom;
    }
    
    /**
     * Method to create new rooms with descriptions
     */
    private void createRooms()
    {
        forest = new Room("in a gloomy forest with trees in every direction"); 
        eastForest = new Room("at an impassable cliff face");
        westForest = new Room("near an impassable river");
        caveEntrance = new Room("at an cave entrance");
        caveRoom = new Room("in a large cave room with a fire tourch on a wall");
        dungeonSouthernCorridor = new Room("in what appears to be a dungeon Corridor");
        dungeonNorthernCorridor = new Room("in the northern part of the dungeon");
        dungeonRoom = new Room("in dungeon room");
        dungeonKeyRoom = new Room("in a dungeon room with a key on a table");
        dungeonDiamondRoom = new Room("in a dungeon room with a shiny diamond in the centre");
        dungeonCoinRoom = new Room("in a what appears to be a dungeon room with a bag of coins."); 
        dungeonExit = new Room("in a room with an exit which the sunlight coming through. You have completed the game");
    }
    
    /**
     * Method to connect the rooms. 
     */
    private void connectRooms()
    {
        forest.setExit("east",eastForest);
        forest.setExit("west",westForest);
        forest.setExit("north", caveEntrance);
        forest.addItem(Items.SWORD);
        
        eastForest.setExit("west", forest);
        eastForest.addItem(Items.GOLDBARS);
        
        westForest.setExit("east", forest);
        westForest.addItem(Items.BOTTLE);
        
        caveEntrance.setExit("north", caveRoom);
        caveEntrance.setExit("south", forest);
        caveEntrance.addItem(Items.TOURCH);
        
        caveRoom.setExit("north", dungeonSouthernCorridor);
        caveRoom.setExit("south", caveEntrance);
        caveRoom.addItem(Items.RUBY);
        
        dungeonSouthernCorridor.setExit("north", dungeonNorthernCorridor);
        dungeonSouthernCorridor.setExit("east", dungeonRoom);
        dungeonSouthernCorridor.setExit("south", caveRoom);
        dungeonSouthernCorridor.setExit("west", dungeonDiamondRoom);
        dungeonSouthernCorridor.addItem(Items.ARMOUR);
        
        dungeonRoom.setExit("west", dungeonSouthernCorridor);
        dungeonRoom.addItem(Items.SHIELD);
        
        dungeonDiamondRoom.setExit("east", dungeonSouthernCorridor);
        
        dungeonNorthernCorridor.setExit("north", dungeonCoinRoom);
        dungeonNorthernCorridor.setExit("south", dungeonSouthernCorridor);
        dungeonNorthernCorridor.setExit("east", dungeonKeyRoom);
        dungeonNorthernCorridor.setExit("west", dungeonDiamondRoom);
        dungeonNorthernCorridor.addItem(Items.CHALICE);
        
        dungeonKeyRoom.setExit("west", dungeonNorthernCorridor);
        dungeonKeyRoom.addItem(Items.KEY);
        
        dungeonDiamondRoom.setExit("east", dungeonNorthernCorridor);
        dungeonDiamondRoom.addItem(Items.DIAMOND);
        
        dungeonCoinRoom.setExit("south", dungeonNorthernCorridor);
        dungeonCoinRoom.setExit("north", dungeonExit);
        dungeonCoinRoom.addItem(Items.BAGOFCOINS);
        
        dungeonExit.setExit("south", dungeonCoinRoom);
    }

    /**
     * Method to put the player at the start of the game
     */
    public Room getStartRoom()
    {
        return startRoom;
    }
    
    public Room currentRoom()
    {
        return currentRoom;
    }
}
