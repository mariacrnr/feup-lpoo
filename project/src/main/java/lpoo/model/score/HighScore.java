package lpoo.model.score;

import lpoo.model.Element;

public class HighScore implements Element, Comparable<HighScore> {
    public static final int MAX_LENGTH = 10;
    private String username;
    private int score;

    public HighScore(String username, int score){
        this.username = username;
        this.score = score;
    }

    public int getTime() {
        return score;
    }

    public int getScore() {
        return score;
    }

    public String getUsername() {
        return username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString(){
        return username + " " + score;
    }

    @Override
    public int compareTo(HighScore o) {
        return score - o.score;
    }


}
