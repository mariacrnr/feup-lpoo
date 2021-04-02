import java.util.ArrayList;
import java.util.List;

public class Band extends Act{
    private String name, country;
    private List<Artist> artists;

    Band(String name, String country){
        this.name = name;
        this.country = country;
        this.artists = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }
    public String getCountry(){
        return this.country;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public List<Artist> getArtists(){
        return artists;
    }

    public boolean containsArtist(Artist artist) {
        for(Artist member: artists)
            if(member.equals(artist)) return true;
        return false;
    }

}
