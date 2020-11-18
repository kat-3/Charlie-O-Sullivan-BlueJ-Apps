/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Charlie O'Sullivan
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // Each ticket and destination, with fixed values.
    public static final Ticket AYLESBURY_TICKET = new Ticket("Aylesbury", 220);
    public static final Ticket AMERSHAM_TICKET = new Ticket("Amersham", 300);
    public static final Ticket HIGHWYCOMBE_TICKET = new Ticket("High Wycombe", 330);

    private Ticket purchasedTicket;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
        purchasedTicket = null;
    }

    /**
     * Method for selecting setting the purchased
     * Ticket to Aylesbury, as well as subtracting
     * balance as long as there is enough money.
     */
    public void selectAylesbury()
    {
        if(balance >= 220) 
        {
            purchasedTicket = AYLESBURY_TICKET;
            balance = balance - 220;
            System.out.println("You have purchased an Aylesbury Ticket for $2.20");
        }
        else
        {
            System.out.println("Please insert $2.20");
        }
    }

    /**
     * Method for selecting setting the purchased
     * Ticket to Amersham, as well as subtracting
     * balance as long as there is enough money.
     */
    public void selectAmersham()
    {
        if(balance >= 300) 
        {
            purchasedTicket = AMERSHAM_TICKET;
            balance = balance - 300;
            System.out.println("You have purchased an Amersham Ticket for $3.00");
        }
        else
        {
            System.out.println("Please insert $3.00");
        }
    }   

    /**
     * Method for selecting setting the purchased
     * Ticket to High Wycombe, as well as subtracting
     * balance as long as there is enough money.
     */
    public void selectHighWycombe()
    {
        if(balance >= 330) 
        {
            purchasedTicket = HIGHWYCOMBE_TICKET;
            balance = balance - 330;
            System.out.println("You have purchased an High Wycombe Ticket for $3.30");
        }
        else
        {
            System.out.println("Please insert $3.30");
        }
    }

    /**
     * Method for updating the amount of balance, based
     * on inserted cash.
     */
    public void balanceUpdate(int cash)
    {
        balance = balance + cash;
        System.out.println("Cash inserted: " + cash);
        showBalance();
    }

    /**
     * Insert various amounts of coins being 10, 20, 100, 200
     */
    public void insert10()
    {
        balanceUpdate(10);
    }

    public void insert20()
    {
        balanceUpdate(20);
    }

    public void insert100()
    {
        balanceUpdate(100);
    }

    public void insert200()
    {
        balanceUpdate(200); 
    }

    public void  showBalance()
    {
        System.out.println("Total balance: " + balance);

    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(purchasedTicket == AYLESBURY_TICKET) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The Aylesbury Line");
            System.out.println("# Ticket");
            System.out.println("# Price: 220");
            System.out.println("# Date: 28/10/2020");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else if(purchasedTicket == AMERSHAM_TICKET)
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The Amersham Line");
            System.out.println("# Ticket");
            System.out.println("# Price: 300");
            System.out.println("# Date: 28/10/2020");            
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else if(purchasedTicket == HIGHWYCOMBE_TICKET)
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The High Wycombe Line");
            System.out.println("# Ticket");
            System.out.println("# Price: 330");
            System.out.println("# Date: 28/10/2020");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("Please choose a destination and purchase a ticket.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
