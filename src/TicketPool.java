import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketPool {
    private final BlockingQueue<Integer> tickets;
    private int totalTicketsSold = 0;

    public TicketPool(int capacity) {
        this.tickets = new LinkedBlockingQueue<>(capacity);
    }

    public synchronized boolean addTicket(Integer ticket) {
        return tickets.offer(ticket);
    }

    public synchronized Integer removeTicket() throws InterruptedException {
        Integer ticket = tickets.take();
        if (ticket != null) {
            totalTicketsSold++;
        }
        return ticket;
    }

    public int getAvailableTickets() {
        return tickets.size();
    }

    public int getTotalTicketsSold() {
        return totalTicketsSold;
    }
}