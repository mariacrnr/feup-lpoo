public class HumanClient implements Client{
    OrderingStrategy strategy;

    public HumanClient(OrderingStrategy strategy) {
        this.strategy = strategy;
    }

    public void happyHourStarted(Bar bar) {
        this.strategy.happyHourStarted((StringBar) bar);
    }

    public void happyHourEnded(Bar bar) {
        this.strategy.happyHourEnded((StringBar) bar);
    }

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.strategy.wants(drink,recipe,bar);
    }
}
