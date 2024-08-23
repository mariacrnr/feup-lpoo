import java.util.Objects;

public class Artist extends Act{
    private String name, country;

    Artist(String name, String country){
        this.name = name;
        this.country = country;
    }
    public String getName(){
        return this.name;
    }
    public String getCountry(){
        return this.country;
    }

    public boolean containsArtist(Artist artist){
        return this.equals(artist);
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Artist artist = (Artist) object;
        return (this.name.equals(artist.name) && this.country.equals(artist.country));
    }

    public int hashCode(){
        return Objects.hash(this.name,this.country);
    }
}
