public class Speaker extends Person implements User{
    private int fee = 0;

    Speaker(String name){
        super(name);
    }
    Speaker(String name, long age){
        super(name,age);
    }

    public int getFee(){
        return this.fee;
    }

    public String toString(){
        return "Speaker " + this.name + " has a fee value of " + this.fee + ".";
    }
    @Override
    public String getUsername() {
        return this.name + this.age;
    }
}
