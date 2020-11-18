import java.util.Date;
/**
 * A Class for creating a ticket, with a destination,
 * price and date on the ticket.
 *
 * @author Charlie O'Sullivan
 * @version 1.0
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
     * Returns the ticket's price.
     */
    public int findTicketPrice()
    {
        return price;
    }
    
    /**
     * Returns the ticket's destination.
     */
    public String findTicketDestination()
    {
        return destination;
    }
    
    /**
     * Returns the ticket's date.
     */
    public Date findTicketDate()
    {
        return ticketDate;
    }
}
