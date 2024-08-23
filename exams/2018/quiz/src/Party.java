import java.util.ArrayList;
import java.util.List;

public class Party extends Event{

    public Party(String place, String date, String name) {
        super(name,date,place);
    }

    public void addEvent(Event event) {
        List<Person> audience = this.getAudience();
        List<Person> eventAudience = event.getAudience();
        audience.addAll(eventAudience);
        this.setAudience(audience);
    }
}
