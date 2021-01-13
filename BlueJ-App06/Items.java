
/**
 * Enumeration class Items - List of Items the User can pick up and use.
 *
 * @author (Tyronne)
 * @version (09/12/2020)
 */
public enum Items
{
    NONE("none"), KEY("key"), POTION("potion"), 
    SWORD("sword"), SHIELD("shield"), TRAPS("traps"), 
    BOTTLE("bottle"), TOURCH("tourch");
    
    private String item;
    
    private Items(String item)
    {
        this.item = item;
    }
    
    public String getValue()
    {
        return item;
    }
}
