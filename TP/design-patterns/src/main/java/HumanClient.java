public class HumanClient implements Client{
    public void happyHourStarted(Bar bar) {
        bar.startHappyHour();
    }

    public void happyHourEnded(Bar bar) {
        bar.endHappyHour();
    }

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

    }
}
