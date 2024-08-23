package lpoo.model.score;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


public class RankingTest {
    @Test
    public void toStringConversion(){
        HighScore highScore = new HighScore("Caseira", 7);

        Assertions.assertEquals("Caseira 7", highScore.toString());
    }

    @Test
    public void processScoreUnsuitable(){
        Ranking ranking = new Ranking();
        ArrayList<HighScore> hs = new ArrayList<>();
        hs.add(new HighScore("João", 8));
        hs.add(new HighScore("Sérgio", 10));
        hs.add(new HighScore("Edgar", 15));

        ranking.setHighScores(hs);
        Assertions.assertFalse(ranking.isHighScoreScore(15));
        Assertions.assertEquals("Edgar 15", ranking.getHighScores().get(2).toString());
    }

    @Test
    public void processScoreSuitable(){
        Ranking ranking = new Ranking();
        ArrayList<HighScore> hs = new ArrayList<>();
        hs.add(new HighScore("Sofia", 9));
        hs.add(new HighScore("Pedro", 16));

        ranking.setHighScores(hs);
        ranking.addScore(new HighScore("Cristiano", 13));

        Assertions.assertTrue(ranking.isHighScoreScore(13));
        Assertions.assertEquals("Cristiano", ranking.getHighScores().get(1).getUsername());
        Assertions.assertEquals("Pedro", ranking.getHighScores().get(2).getUsername());

    }


}
