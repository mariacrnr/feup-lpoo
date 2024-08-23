package lpoo.model.score;

import lpoo.model.Configuration;
import lpoo.model.Element;

public class GameOverMenu implements Element {
    private final Configuration configuration;
    private final boolean isWin;
    private final int score;
    private Ranking ranking;

    public GameOverMenu(Configuration configuration, boolean isWin, int score){
        this.configuration = configuration;
        this.isWin = isWin;
        this.score = score;

        RankingDataStorage reader = new RankingDataStorage();
        reader.read();
        this.ranking = new Ranking();
        this.ranking.setHighScores(reader.getHighScores());
    }

    public boolean isWin() {
        return isWin;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public int getScore() {
        return score;
    }

    public boolean isHighScore() {
        return ranking.isHighScoreScore(score);
    }
}
