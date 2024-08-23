public class StringBar extends Bar{
    StringBar(){
        super();
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}
