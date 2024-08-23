import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert{
    private String city, country, date;
    private List<Act> acts;
    Concert(String city, String country, String date){
        this.city = city;
        this.country = country;
        this. date = date;
        this.acts = new ArrayList<>();
    }
    public void addAct(Act act){
        this.acts.add(act);
    }
    public List<Act> getActs(){
        return this.acts;
    }
    public String getCity(){
        return this.city;
    }
    public String getCountry() {
        return country;
    }
    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Concert concert = (Concert) object;
        return (this.city.equals(concert.city) && this.country.equals(concert.country) &&
                this.date.equals(concert.date) && this.acts.equals(concert.acts));
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.city,this.country,this.city, this.acts);
    }

    public boolean isValid(Ticket ticket){
        return (this.equals(ticket.getConcert()));
    }

    public boolean participates(Artist artist) {
        for(Act act: acts)
            if(act.containsArtist(artist)) return true;
        return false;
    }
}
