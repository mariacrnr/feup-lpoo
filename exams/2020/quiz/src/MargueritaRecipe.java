public class MargueritaRecipe extends Recipe {
    @Override
    public Pizza makeMediumPizza() {
        Pizza marguerita = new MediumPizza();
        marguerita.addIngredient(new Ingredient("Tomato"));
        marguerita.addIngredient(new Ingredient("Basil"));
        marguerita.addIngredient(new Ingredient("Mozzarella"));
        return marguerita;
    }
}
