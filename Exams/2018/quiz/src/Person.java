public abstract class Person implements Comparable{
    protected String name;
    protected long age;
    Person(String name){
        this.name = name;
    }
    Person(String name, long age){
        this.name = name;
        this.age = age;
    }
    public long getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public int compareTo(Object o) {
        Person person = (Person) o;
        return this.getName().compareTo(person.getName());
    }

    public abstract String toString();

}
