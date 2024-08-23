package lpoo.model.menu;

import lpoo.model.Configuration;
import lpoo.model.score.HighScoreMenu;
import lpoo.model.score.Ranking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HighScoreMenuTest {
    Ranking ranking;
    HighScoreMenu menu;
    Configuration configuration;

    @BeforeEach
    public void HighScoreMenuInit(){
        ranking = new Ranking();
        configuration = new Configuration(20, 20, 30);
        menu =  new HighScoreMenu(5, ranking, configuration);
    }

    @Test
    public void changeName(){

        menu.addChar('C');
        menu.addChar('A');
        menu.addChar('T');
        menu.addChar('S');
        menu.deleteLastLetter();

        Assertions.assertEquals("CAT", menu.getUsername());
    }

    @Test
    public void deleteEmpty(){

        menu.deleteLastLetter();

        Assertions.assertTrue(menu.isEmpty());
    }


}
