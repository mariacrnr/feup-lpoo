import java.util.ArrayList;
import java.util.List;

public abstract class Bar {
    private boolean isHappyHour;
    private List<BarObserver> observers;
    Bar(){
        this.isHappyHour = false;
        this.observers =  new ArrayList<BarObserver>();
    }
    public boolean isHappyHour() {
        return this.isHappyHour;
    };
    public void startHappyHour() {
        this.isHappyHour = true;
        notifyObservers();
    };
    public void endHappyHour() {
        this.isHappyHour = false;
        notifyObservers();
    };
    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
}
