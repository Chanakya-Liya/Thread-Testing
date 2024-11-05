public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int releaseRate; // Tickets per second (adjust as needed)
    private final String vendorName;
    private static int id = 1;


    public Vendor(TicketPool ticketPool, int releaseRate, String vendorName) {
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
        this.vendorName = vendorName;

    }

    @Override
    public void run() {
        while (id < 500) {
            try {
                for (int i = 0; i < releaseRate; i++) {
                    if(ticketPool.addTicket(id)){
                        System.out.println(vendorName+ " Released ticket: " + id);
                        id++;
                    }
                }
                Thread.sleep(1000); // Release tickets every 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption gracefully
                System.out.println(vendorName+ " interrupted.");

            }
        }


    }
}