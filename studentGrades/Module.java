
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
     * Module Constructor
     */
    public Module(String title, String moduleNo)
    {
        mark = 0;
        this.title = title;
        this.moduleNo = moduleNo;
        completed = false;
    }
    
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
    
    
    public void print()
    {
        System.out.println("Module: " + moduleNo + " " + title + " Mark = " + mark + "%");
    }
}
