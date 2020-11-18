import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * Modified by Charlie O'Sullivan
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    // Creates a random numbe.r
    private Random randomNumberGenerator;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        randomNumberGenerator = new Random();
        
        manager.addProduct(new Product(101, "Samsung Galaxy S20"));
        manager.addProduct(new Product(102, "Apple iPhone 12"));
        manager.addProduct(new Product(103, "Google Pixel 4A"));
        manager.addProduct(new Product(104, "OnePlus 8"));
        manager.addProduct(new Product(105, "Xiomi Mi 10"));
        manager.addProduct(new Product(106, "Google Pixel 5"));
        manager.addProduct(new Product(107, "Samsung Galaxy Note 20"));
        manager.addProduct(new Product(108, "Xiaomi Redmi Note 9"));
        manager.addProduct(new Product(109, "OnePlus 7T Pro"));
        manager.addProduct(new Product(110, "Oppo Find X2"));
    }
    
    private void demoDeliverProducts()
    {
        int quantity = 0;
        
        for(int id = 101; id <= 110; id++)
        {
           quantity = randomNumberGenerator.nextInt(10) +1;
           manager.deliverProduct(id, quantity);
        }
    }

     /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of products are shown, the
     * product is restocked, and then the details are shown again.
     */
    private void demoSellProducts()
    {
        int quantity = 0;
        
        for(int id = 101; id <= 110; id++)
        {
           quantity = randomNumberGenerator.nextInt(5) +1;
           manager.sellProduct(id, quantity);
        }
    }
    
    /**
     * Provides a simple demonstration of how a StockManager
     * might be used. 
     */
    public void runDemo()
    {
        manager.printAllProducts();
        demoDeliverProducts();
        manager.printAllProducts();
        demoSellProducts();
        manager.printAllProducts();
        manager.removeProduct(101);
        manager.renameProduct(105, "Xiaomi Mi 10");
        manager.searchProducts("Google");
        manager.printAllProducts();
    }
    
}
