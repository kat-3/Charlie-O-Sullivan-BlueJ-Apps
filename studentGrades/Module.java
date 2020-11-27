
/**
 * Creates a module which contains a title, module number and the mark of the module.
 *
 * @author Charlie O'Sullivan
 * @version 1
 */
public class Module
{
    private String title;
    private String moduleNo;
    private int mark;
    private boolean completed;
    /**
     * Constructor for the module class.
     */
    public Module(String title, String moduleNo)
    {
        mark = 0;
        this.title = title;
        this.moduleNo = moduleNo;
        completed = false;
    }
    
    public int getMark()
    {
        return mark;
    }
    
    /**
     * Awards a mark to the value
     * Not allowing marks below 0 
     * and above 100.
     */
    public void awardMark(int mark)
    {
        if ((mark >= 0) && (mark <= 100))
        {
            this.mark = mark;
            if(mark >= 40)completed = true;
        }
        else
        {
            System.out.println("Please insert a valid mark.");
        }
    }

    public boolean isComplete()
    {
        return this.completed;
    }

    /**
     * Prints out the module's information which 
     * includes the title, module number and
     * the mark of the module.
     */
    public void print()
    {
        System.out.println("Module: " + moduleNo + " " + title);
        
        if(isComplete())
        {
            System.out.println(" mark = " + mark + "%");
        }
        
        else
        {
            System.out.println(" This module is not yet completed.");
        }
    }
}
