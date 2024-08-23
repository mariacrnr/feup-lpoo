package lpoo.model.score;

import java.util.ArrayList;
import java.util.Collections;

public class Ranking {
    private ArrayList<HighScore> highScores;
    private final int MAXSIZE = 3;

    public Ranking(){
        this.highScores = new ArrayList<>();
    }

    public ArrayList<HighScore> getHighScores() {
        return highScores;
    }

    public void setHighScores(ArrayList<HighScore> highScores) { this.highScores = highScores; }

    public boolean isHighScoreScore(long score){
        return highScores.get(highScores.size() - 1).getTime() > score;
    }

    public void addScore(HighScore highScore){
        if (highScores.size() == MAXSIZE)
            highScores.remove(MAXSIZE - 1);
        highScores.add(highScore);
        Collections.sort(highScores);
    }


    public int getMaxSize() {
        return MAXSIZE;
    }
}
