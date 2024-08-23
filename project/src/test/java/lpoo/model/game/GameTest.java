package lpoo.model.game;

import lpoo.model.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

public class GameTest {

    @Test
    public void gameScore(){
        Configuration configuration = new Configuration(20, 20, 30);
        Board board = Mockito.mock(Board.class);
        Game game = new Game(configuration,board);

        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException ie){
            System.out.println("Sleep interrupted");
        }

        Assertions.assertEquals(13, game.getScore()); // 1 / (30 / (20 * 20)) = 13.33 ~ 13
    }

}
