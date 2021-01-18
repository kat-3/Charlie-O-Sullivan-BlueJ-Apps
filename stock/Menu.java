
/**
 * Class which allows the user to make an integer input to select options.
 *
 * @author Charlie O'Sullivan
 * @version 08/1/2021 1.0
 */
public class Menu
{
    private static InputReader reader = new InputReader();
    /**
     * Gets the integer input from the user printing off an error if an
     * invalid input is entered.
     */
    public static int getIntChoice(String [] choices)
    {
        int choice = 0;
        boolean validChoice = false;
        
        while(!validChoice)
        {
            printChoices(choices);
            choice = reader.getInt("\n    Enter choice number > ");
            
            if(choice > 0 && choice <= choices.length)
                validChoice = true;
            else
                System.out.println("\n " + choice + " is not a valid choice!\n");
                
        }

        return choice;
    }
    /**
     * Prints off the user choices in the list,
     */
    private static void printChoices(String [] choices)
    {
        for(int index = 0; index < choices.length; index++)
        {
            System.out.println("    " + (index + 1) + ". " + choices[index]);
        }
    }
}