public class Ticket {
    private int number;
    private Concert concert;
    Ticket(int number, Concert concert) throws InvalidTicket {
        this.concert = concert;
        if(number < 0) throw new InvalidTicket();
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Concert getConcert() {
        return concert;
    }
}
