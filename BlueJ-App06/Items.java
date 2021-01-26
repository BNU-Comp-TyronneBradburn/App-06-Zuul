
/**
 * Enumeration class Items - List of Items the User can pick up and use.
 *
 * @author (Tyronne)
 * @version (09/12/2020)
 */
public enum Items
{
    NONE("none"), KEY("Key"), CHALICE("Chalice"), GOLDBARS("Gold Bars"),
    SWORD("Magic Sword"), SHIELD("Magic Shield"), ARMOUR("Magic Armour"), 
    BOTTLE("Magic Bottle"), TOURCH("Tourch"), BAGOFCOINS("Bag of coins"),
    DIAMOND("Diamond"), RUBY("Ruby");
    
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
