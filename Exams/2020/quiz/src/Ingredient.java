import java.util.Objects;

public class Ingredient {
    private String name;
    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Ingredient ingredient = (Ingredient) object;
        return (this.name.equals(ingredient.name));
    }

    public int hashCode(){
        return Objects.hash(this.name);
    }
}
