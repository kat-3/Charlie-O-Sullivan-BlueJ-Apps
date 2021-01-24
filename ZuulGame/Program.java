
/**
 * Class for creating an instance of the Game class, calling
 * its run method.
 *
 * @author Charlie O'Sullivan
 * @version 1
 */
public class Program
{
    private static Game game;
    
    /**
     * Runs an instance of the Game class
     */
    
    public static void main()
    {
        game = new Game("Charlie");
        game.play();
    }
}
