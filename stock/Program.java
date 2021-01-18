import java.io.IOException;
import java.lang.InterruptedException;

/**
 * Program Class for initiating the StockApp and Input Reader
 *
 * @author Charlie O'Sullivan
 * @version 08/01/2021 1.0
 */
public class Program
{
    // Gathers input from the user
    private InputReader input;

    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main() throws IOException, InterruptedException
    {
        app = new StockApp();
        app.run();
    }
}

