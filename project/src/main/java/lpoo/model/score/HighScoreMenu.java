package lpoo.model.score;

import lpoo.model.Configuration;
import lpoo.model.Element;

import static lpoo.model.score.HighScore.MAX_LENGTH;

public class HighScoreMenu implements Element {
    private final Configuration configuration;
    private final int score;
    private Ranking ranking;
    private String username;

    public HighScoreMenu(int score, Ranking ranking, Configuration configuration){
        this.score = score;
        this.username = "";
        this.ranking = ranking;
        this.configuration = configuration;
    }

    public void addChar(Character letter) {
        if (username.length() < MAX_LENGTH && Character.isAlphabetic(letter))
            username += letter;
    }

    public void deleteLastLetter() {
        if (username.length() > 0)
            username = username.substring(0, username.length() - 1);
    }

    public String getUsername() {
        return username;
    }

    public boolean isEmpty() {
        return username.isEmpty();
    }

    public void addHighScore() {
        ranking.addScore(new HighScore(username, score));

        RankingDataStorage writer = new RankingDataStorage();
        writer.setHighScores(ranking.getHighScores());
        writer.write();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
