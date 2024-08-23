package lpoo.model.score;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class RankingDataStorage implements DataStorage {
    private final String path = "src/main/resources/data/highScores.txt";
    private ArrayList<HighScore> highScores = new ArrayList<>();

    @Override
    public void read(){
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null){
                String[] score = line.split(" ");
                highScores.add(new HighScore(score[0], parseInt(score[1])));
            }
            br.close();
        }
        catch (IOException ioe){
            System.out.println("Not found");
        }
    }

    @Override
    public void write(){
        try{
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);

            String line;
            for (HighScore hs: highScores) {
                line = hs.toString();
                pw.println(line);
            }
            pw.close();
        }
        catch (IOException ioe){
            System.out.println("Not found");
        }
    }

    public ArrayList<HighScore> getHighScores() {
        return highScores;
    }

    public void setHighScores(ArrayList<HighScore> highScores) {
        this.highScores = highScores;
    }


}
