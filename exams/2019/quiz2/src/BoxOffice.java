import java.util.*;

public class BoxOffice {
    private static final Map<Concert, Integer> tickConcert = new HashMap<>();
    public static List<Ticket> buy(Concert concert, int noTickets) throws InvalidTicket{
        List<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i < noTickets; i++){
            tickConcert.putIfAbsent(concert,1);
            int number = tickConcert.get(concert);
            Ticket ticket = new Ticket(number,concert);
            tickets.add(ticket);
            tickConcert.put(concert,number+1);
        }
        return tickets;
    }
}
