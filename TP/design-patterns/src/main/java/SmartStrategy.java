import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartStrategy implements OrderingStrategy{
    private HashMap<StringDrink,StringRecipe> waiting;
    SmartStrategy(){
        this.waiting = new HashMap<>();
    }
    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()) bar.order(drink,recipe);
        else waiting.put(drink,recipe);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for (HashMap.Entry<StringDrink, StringRecipe> entry : waiting.entrySet()) {
            bar.order(entry.getKey(),entry.getValue());
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {}
}
