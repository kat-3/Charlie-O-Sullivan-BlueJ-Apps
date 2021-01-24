import java.util.ArrayList;

/**
 * This class stores information about the player
 * including the player's current state in terms
 * of energy, score and the number of turns so far.
 * The player can carry a number of items up to 
 * the maximum weight.
 *
 * @author Charlie O'Sullivan
 * @version 1.0
 */
public class Player
{
    public static final int MAX_ENERGY = 100;
    public static final int MIN_ENERGY = 10;

    public static final int MAX_PROVISION = 100;
    public static final int MIN_PROVISION = 10;
    public static final int PROVISION_LOSS = 3;
    
    public static final int MOVE_ENERGY = 4;
    
    private String name;

    private int score;

    private int moves;

    private int energy;

    private int water;
    
    private int food;
    
    private boolean alive;

    private ArrayList<ItemTypes> items;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        items = new ArrayList<ItemTypes>();

        score = 0;
        moves = 0;
        
        food = MAX_PROVISION;
        water = MAX_PROVISION;
        energy = MAX_ENERGY;

        alive = true;
    }

    /**
     * Returns the name of the player.
     */
    public String getName()
    {
        return this.name;
    }//end method getName

    /**
     * Sets the name of the player.
     */
    public void setName(String name)
    {
        this.name = name;
    }//end method setName

    /**
     * Returns the score of the player.
     */
    public int getScore()
    {
        return this.score;
    }//end method getScore

    /**
     * Increases the players score by an integer input.
     */
    public void increaseScore(int amount)
    {
        score = score + amount;
    }//end method setScore

    /**
     * Decreases the score by an integer input.
     */
    public void decreaseScore(int amount)
    {
        score = score - amount;
        if(score < 0)score = 0;
    }//end method setScore

    /**
     * Returns the amount of moves a player has.
     */
    public int getMoves()
    {
        return this.moves;
    }

    /**
     * Increases the amount of moves a player has by integer input.
     */
    public void increaseMoves()
    {
        this.moves++;
        this.energy -= MOVE_ENERGY;

        useProvisions(ItemTypes.WATER, water);
        useProvisions(ItemTypes.FOOD, food);
        
        if(energy < MIN_ENERGY)
            alive = false;
    }

    /**
     * Uses the provision item the player has.
     */
    private void useProvisions(ItemTypes item, int provision)
    {
        if(isCarrying(item))
        {
            provision -= (PROVISION_LOSS/2);
            energy += 2;
        }
        else
        {
            water -= PROVISION_LOSS;
        }
        
        if(provision < MIN_PROVISION)
            alive = false;
        
    }
    
    /**
     * Returns the amount of energy a player has.
     */
    public int getEnergy()
    {
        return this.energy;
    }

    /**
     * Increases the player's energy by an integer input.
     */
    public void increaseEnergy(int increase)
    {
        this.energy += increase;
        if(energy > MAX_ENERGY)energy = MAX_ENERGY;
    }

    /**
     * Reduces the player's energy by an integer input.
     */
    public void decreaseEnergy(int decrease)
    {
        this.energy -= decrease;
        if(energy < MIN_ENERGY)
            alive = false;
    }

    /**
     * Returuns if the player is alive or not.
     */
    public boolean isAlive()
    {
        return this.alive;
    }

    /**
     * Sets the player's alive state to true.
     */
    public void setAlive()
    {
        this.alive = true;
    }

    /**
     * Displays all the items the player has.
     */
    public ArrayList<ItemTypes> getItems()
    {
        return this.items;
    }

    /**
     * Adds an item to the players carrying list, if they don't have it
     * already.
     */
    public void addItem(ItemTypes item)
    {
        if(!isCarrying(item))
            this.items.add(item);
        }

    /**
     * Removes an item from the player's carrying list.
     */
    public void removeItem(ItemTypes item)
    {
        this.items.remove(item);
    }    

    /**
     * Displays the players name, what move they are on, the amount of 
     * energy they have and their total score.
     */
    public String toString()
    {
        String 
        output = "\n ----------------------------------------------" +
            "\n | " + name + ": | Move " + moves + " | Energy = " + energy +
            " | Score = " + score + " |" +
            "\n ----------------------------------------------\n";

        output += showItems();
        return output;
    }

    /**
     * Displays if the player is carrying a specific item.
     */
    public boolean isCarrying(ItemTypes item)
    {
        return items.contains(item);
    }
    
    /**
     * Displays in a list what items the player is carrying.
     */
    public String showItems()
    {
        String inventory = "\n You are carrying: ";
        int count = 0;
        
        if(items.size() == 0)
            inventory += "nothing!";
        else
        {
            for(ItemTypes item : items)
            {
                count++;
                inventory += item;

                if(count < items.size())
                {
                    inventory += ", ";
                }
                else
                {
                    inventory += "\n";
                }
            }
        }
        return inventory;
    }
}