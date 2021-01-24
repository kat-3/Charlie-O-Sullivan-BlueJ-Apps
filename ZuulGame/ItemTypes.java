
/**
 * 
 *
 * @author Charlie O'Sullivan
 * @version 1.0
 */
public enum ItemTypes
{
    NONE("none"), KEY("keys"), BOTTLE("bottle"), WATER("water"), 
    FOOD("apples"), TREASURE("treasure");
    
    private String itemString;
    
    ItemTypes(String itemString)
    {
        this.itemString = itemString;
    }
    
    public String toString()
    {
        return itemString;
    }
}
