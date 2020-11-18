import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Charlie O'Sullivan   
 * @version 1
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println("Product ID" + id + " is invalid. \n"); 
        }
        else
        {
            product.increaseQuantity(amount);
            System.out.println("Product stock increased by " + amount);
            System.out.println(product + "\n");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * If in stock, reduces the product's stock by the given quantity.
     */
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println("Selling Product: Order Quantity = " + quantity);
            printProduct(id);

            int noSold = quantity;
            if(noSold > product.getQuantity())
            {
                noSold = product.getQuantity();
            }
            
            for(int count = 0; count < noSold; count++)
            {
                product.sellOne();
            }
            
            System.out.println("  " + noSold + " items sold!\n");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID() == id)
            {
                return product;
            }
        }
        
        return null;
    }

    /**
     * Try to find a product in the stock with the given id.
     * If a product ID is correct, the product will be removed from stock.
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println("Product ID" + id + " is invalid. \n"); 
        }
        else
        {
            stock.remove(product);
            System.out.println("Product with ID " + id + " Has been removed from the system.");
        }
    }
    
    /**
     * Uses a input to see if a product contains the input inside of it.
     */
    public void searchProducts(String searchTerm)
    {
        int amount = 0;
        System.out.println("Looking for products containing: " + searchTerm);
        
        for(Product product : stock)
        {
            if(product.getName().contains(searchTerm))
            {
                System.out.println(product);
                amount++;
            }
        }
    }
    
    
    
    /**
     * Renames a product from the list if the ID is correct
     * and prints out the updated name
     * else returns and error.
     */
   
    public void renameProduct(int id, String updatedName)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println("Product ID" + id + " is invalid. \n"); 
        }
        else
        {
            System.out.println(product);
            product.setName(updatedName);
            System.out.println("Product has been renamed.");
            System.out.println(product);
        }
    }    
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }

    public ArrayList<Product> printLowStock(int minimum)
    {
        ArrayList<Product> lowStock = new ArrayList<Product>();
        int amount = 0;
        
        System.out.println("Printing products that are low on stock \n");
        
        for(Product product : stock)
        {
            if(product.getQuantity() <= minimum)
            {
                amount++;
                lowStock.add(product);
                System.out.println(product);
            }
        }
        
        System.out.println("\n There were " + amount + " products with stock less than "
        + minimum);
        
        return lowStock;
    }
    
    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);

        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }

    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printAllProducts()
    {
        System.out.println();
        System.out.println("Kat's Stock List");
        System.out.println("====================");
        System.out.println();

        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
}
