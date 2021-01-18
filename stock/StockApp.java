
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    private StockManager manager;
    private String[] menuChoices;
    private InputReader reader;
    
    public static final String ADD = "Add Product";
    public static final String DELIVER = "Deliver Product";
    public static final String SELL = "Sell Product";
    public static final String SEARCH = "Search for Product";
    public static final String REMOVE = "Remove Product";
    public static final String PRINT_LOW_STOCK = "Print Low Stock";
    public static final String PRINT_ALL = "Print All Products";
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()    
    {
       menuChoices = new String[]
        {
            ADD, DELIVER, SELL,
            SEARCH, REMOVE, PRINT_LOW_STOCK,
            PRINT_ALL
        };
    }
    
    {
        reader = new InputReader();
        manager = new StockManager();
    }

    /**
     *  Display a list of menu choices and get the user's
     *  choice, using the menu class.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();

            int choice = Menu.getIntChoice(menuChoices);
            
            finished = executeIntChoice(choice);
        }
    }
    
    /**
     * Call on methods of the StockManager to
     * execute the selected menu choice
     */
    private boolean executeIntChoice(int choice)
    {
        
        switch(choice)
        {
            case 1: addProduct(); break;
            case 2: deliverProduct(); break;
            case 3: sellProduct(); break;
            case 4: searchProducts(); break;
            case 5: removeProduct(); break;
            case 6: printLowStock(); break;
            case 7: manager.printAllProducts(); break;
            case 8: return true;
            
            default: System.out.println(
                "    Please enter a choice between 1 and " + menuChoices.length);
        }
        
        return false;
    }    
    
    /**
     * Allows the user to add a new product to the stock list.
     */
    private void addProduct()
    {
        System.out.println(" Adding a new product\n");
        
        String prompt = "\n Please enter the product's ID number: ";
        int code = reader.getInt(prompt);
        
        prompt = "Please enter the product's name: ";
        String name = reader.getString(prompt);
        
        Product product = new Product(code, name);
        manager.addProduct(product);
        manager.deliverProduct(code, 1);
        
        System.out.println("\n" + product + " has been added to stock. \n");
        
    }
    
    /**
     * Allows the user to get a delivery for an exisiting product,
     * from the specified ID.
     */
    private void deliverProduct()
    {
        System.out.println(" Delivery for an existing product\n)");
        Product product = getProduct();
        
        if(product != null)
        {
            String prompt = "\n Please enter the order quantity: ";
            int quantity = reader.getInt(prompt);
            
            manager.deliverProduct(product.getID(), quantity);
            System.out.println("Delivery of: " + quantity + " " + product +
            "completed sucessfully.\n");
        }
        
    }
    
    /**
     * Allows the user to remove a product from the stock list, with the
     * specified ID.
     */
    private void removeProduct()
    {
        System.out.println("Removing a product from the database\n");
        Product product = getProduct();
        
        if(product != null)
        {
            manager.removeProduct(product.getID());
            System.out.println(product + " has been removed sucessfully./n");
        }
    }
    
    /**
     * Prints off all the low stock products from the product list.
     */
    private void printLowStock()
    {
        String prompt = "\n Please enter the minimum stock level: ";
        int minimum = reader.getInt(prompt);
        
        System.out.println("Printing products that have a stock under " + 
        minimum + "\n");
        
        manager.printLowStock(minimum);
    }
    
    /**
     * Searches through all of the products containing the keyword input.
     */
    private void searchProducts()
    {
        String prompt = "\n Please enter the search term: ";
        String target = reader.getString(prompt);
        
        System.out.println("Printing products that contain " + target + "\n");
        
        manager.searchProducts(target);
    }
    
    /**
     * Gets a product from the product list, from the ID specified.
     */
    private Product getProduct()
    {
        String prompt = "\n Please enter product ID number: ";
        
        int id = reader.getInt(prompt);
        Product product = manager.findProduct(id);
        
        if(product == null)
            System.out.println("Product with id: " + id + " not found.");
           
        return product;    
    }
    /**
     * Allows the user to sell a specified product from the product list.
     */
    private void sellProduct()
    {
        System.out.println(" Sell an existing product\n");
        Product product = getProduct();
        
        if(product != null)
        {
            String prompt = "\n Please insert the amount to be sold: ";
            int quantity = reader.getInt(prompt);
            
            manager.sellProduct(product.getID(), quantity);
            System.out.print("\n" + quantity + " Amount of " + product +
            " have been sold sucessfully.\n");
            
        }
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Sell:       Sell a product");
        System.out.println("    Deliver:    Deliver a product");
        System.out.println("    Search:     Search for a product");
        System.out.println("    LowStock:   Check for products with low stock");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Charlie O'Sullivan");
        System.out.println("******************************");
    }
}
