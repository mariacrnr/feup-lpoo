package lpoo.model.score;

import lpoo.model.score.HighScore;
import lpoo.model.score.RankingDataStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class RankingDataStorageTest {

    @Test
    public void readOrder(){
        RankingDataStorage reader = new RankingDataStorage();
        reader.read();

        ArrayList<HighScore> highScores = reader.getHighScores();

        for (int i = 0; i < highScores.size() - 1; i++)
            Assertions.assertTrue(highScores.get(i).getTime() <= highScores.get(i+1).getTime());
    }
}


