public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int retrievalRate;
    private final String customerName;
    private static int id = 1;

    public Customer(TicketPool ticketPool, int retrievalRate, String customerName) {
        this.ticketPool = ticketPool;
        this.retrievalRate = retrievalRate;
        this.customerName = customerName;
    }
    @Override
    public void run() {
        while (id < 30000) {
            try {
                for (int i = 0; i < retrievalRate; i++) {

                    Integer ticket = ticketPool.removeTicket();
                    if(ticket!=null) {
                        System.out.println(customerName + " purchased ticket: " + ticket);
                    }

                }
                Thread.sleep(3000); // Attempt purchase every 1 second
                id++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(customerName+" interrupted.");
            }

        }
    }
}