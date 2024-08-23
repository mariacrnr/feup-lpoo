package lpoo.model.game;

import lpoo.model.Configuration;
import lpoo.model.Element;

public class Game implements Element {
    private final Board board;
    private final Cursor cursor;
    private final Configuration configuration;
    private final Timer timer;
    public static final int FRAME_OFFSET = 2;

    public Game(Configuration configuration, Board board){
        this.configuration = configuration;
        this.board = board;
        this.cursor = new Cursor(0,0, board.getHeight(), board.getWidth());
        this.timer = new Timer();
    }

    public Board getBoard() {
        return board;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public Tile selectedTile() {
        return board.getTileAtPosition(cursor.getPosition());
    }

    public Timer getTimer() { return timer; }

    public Configuration getConfiguration() {
        return configuration;
    }

    public int getScore(){
        double density = (double)configuration.getNumMines() /(configuration.getHeight()* configuration.getWidth());
        return (int) (timer.getTime()/density);
    }
}
