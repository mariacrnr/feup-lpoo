import java.util.HashSet;

public class MargueritaCertifier extends PizzaCertifier {

    @Override
    public boolean isCertified(Pizza pizza) {
        return (pizza.contains(new Ingredient("Tomato"))
                && pizza.contains(new Ingredient("Basil")) &&
                pizza.contains(new Ingredient("Mozzarella"))
                && pizza.getIngredientCount() == 3);
    }
}
