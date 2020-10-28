import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket
{
    
    private String destination;
    
    private int price;
    
    private Date ticketDate = new Date();

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String destination, int price)
    {
        this.destination = destination;
        this.price = price;
    }
    
    /**
     * 
     */
    public int findTicketPrice()
    {
        return price;
    }
    
    /**
     * 
     */
    public String findTicketDestination()
    {
        return destination;
    }
    
    /**
     * 
     */
    public Date findTicketDate()
    {
        return ticketDate;
    }
}
