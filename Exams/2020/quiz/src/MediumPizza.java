import java.util.HashSet;

public class MediumPizza implements Pizza {
    private double price;
    private HashSet<Ingredient> ingredientList;

    MediumPizza(){
        this.ingredientList = new HashSet<>();
        this.price = 0.0;
    }
    public boolean addIngredient(Ingredient ingredient) {
        return ingredientList.add(ingredient);
    }

    @Override
    public int getIngredientCount() {
        return ingredientList.size();
    }

    @Override
    public boolean contains(Ingredient ingredient){
        return ingredientList.contains(ingredient);
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

}
