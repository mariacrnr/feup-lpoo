import java.util.HashSet;
import java.util.List;
public class GenericRecipe extends Recipe {
    private List<Ingredient> ingredients;
    GenericRecipe(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }
    @Override
    public Pizza makeMediumPizza() {
        Pizza pizza = new MediumPizza();
        for(Ingredient ingredient: ingredients)
            pizza.addIngredient(ingredient);
        return pizza;
    }
}
