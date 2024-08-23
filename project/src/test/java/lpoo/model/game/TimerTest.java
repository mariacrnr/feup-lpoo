package lpoo.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class TimerTest {

    @Test
    public void timer(){

        Timer timer = new Timer();
        try {
            TimeUnit.SECONDS.sleep(1);
            Assertions.assertEquals(1, timer.getTime());

        } catch ( InterruptedException ie ){
            System.out.println("Sleep interrupted");
        }


    }
}
