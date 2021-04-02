public class Attendee extends Person implements User{
    private boolean hasPaid = false;

    Attendee(String name){
        super(name);
    }
    Attendee(String name, long age){
        super(name,age);
    }

    public boolean hasPaid(){
        return this.hasPaid;
    }

    public String toString(){
        return "Attendee " + this.name + (this.hasPaid() ? " has" : " hasn't") + " paid its registration.";
    }

    @Override
    public String getUsername() {
        return this.name+this.age;
    }
}
