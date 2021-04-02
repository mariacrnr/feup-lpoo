public class Artist extends Person implements User{
    Artist(String name) {
        super(name);
    }
    Artist(String name, long age){
        super(name,age);
    }

    @Override
    public String toString(){
        return toString();
    }

    @Override
    public String getUsername() {
        return this.name + this.age;
    }
}
