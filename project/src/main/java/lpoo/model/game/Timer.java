package lpoo.model.game;

import lpoo.model.Element;

public class Timer implements Element {
    public static final int TIMER_HEIGHT = 5;
    long start;

    public Timer(){
        start = System.currentTimeMillis();
    }

    public long getTime(){
        return (System.currentTimeMillis() - start)/1000;
    }
}
