import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title = "", date = "", description = "";
    private List<Person> audience = new ArrayList<>();

    Event(String title){
        this.title = title;
    }
    Event(String title, String date){
        this.title = title;
        this.date = date;
    }

    Event(String title, String date, String description){
        this.title = title;
        this.date = date;
        this.description = description;
    }
    Event(Event event){
        this.title = event.title;
        this.date = event.date;
        this.description = event.description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }
    protected void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }
    protected void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getAudience() {
        return audience;
    }
    protected void setAudience(List<Person> audience){
        this.audience = audience;
    }
    @Override
    public String toString(){
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }
    @Override
    public boolean equals(Object object){
        if( this == object) return true;
        if( object == null) return false;
        if( getClass() != object.getClass()) return false;
        Event event = (Event) object;
        return this.date.equals(event.date) && this.title.equals(event.title)
                && this.description.equals(event.description);
    }

    public void addPerson(Person person) {
        for(Person member: audience)
            if (member.getName().equals(person.getName())) return;
        this.audience.add(person);
    }

    public int getAudienceCount() {
        return this.audience.size();
    }
}
