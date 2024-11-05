//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {
        // (Use Apache Commons CLI to parse args for totalTickets, rates, capacity)

        // Example (replace with CLI parsing)
        int totalTickets = 1000;
        int ticketReleaseRate = 10;
        int customerRetrievalRate = 5;
        int maxTicketCapacity = 200;

        TicketPool ticketPool = new TicketPool(maxTicketCapacity);

        // Create and start vendor and customer threads
        Vendor vendor1 = new Vendor(ticketPool, ticketReleaseRate,"vendor 1");
        Vendor vendor2 = new Vendor(ticketPool, ticketReleaseRate,"vendor 2");
        Customer customer1 = new Customer(ticketPool, customerRetrievalRate,"customer 1");
        Customer customer2 = new Customer(ticketPool,customerRetrievalRate,"customer 2");
        Thread vendorThread1 = new Thread(vendor1);
        Thread vendorThread2 = new Thread(vendor2);

        Thread customerThread1 = new Thread(customer1);
        Thread customerThread2 = new Thread(customer2);
        vendorThread1.start();
        vendorThread2.start();
        customerThread1.start();
        customerThread2.start();
    }
}