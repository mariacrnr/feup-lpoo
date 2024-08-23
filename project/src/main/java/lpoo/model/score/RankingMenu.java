package lpoo.model.score;

import lpoo.model.Configuration;
import lpoo.model.Element;

public class RankingMenu implements Element {
    private final Configuration configuration;
    private Ranking ranking;

    public RankingMenu(Configuration configuration){
        this.configuration = configuration;

        RankingDataStorage reader = new RankingDataStorage();
        reader.read();
        this.ranking = new Ranking();
        ranking.setHighScores(reader.getHighScores());
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Ranking getRanking() {
        return ranking;
    }
}
