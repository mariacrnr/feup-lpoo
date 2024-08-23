package lpoo.model;

public class Configuration {
    private final int MAXSIZE = 20;
    private final int MINSIZE = 6;
    private final int MINMINES = 1;
    private int height;
    private int width;
    private int numMines;

    public Configuration(int height, int width, int numMines){
        this.height = height;
        this.width = width;
        this.numMines = numMines;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = Math.max(height, MINSIZE);
        this.height = Math.min(this.height, MAXSIZE);
        setNumMines(numMines);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = Math.min(width, MAXSIZE);
        this.width = Math.max(this.width, MINSIZE);
        setNumMines(numMines);
    }

    public int getNumMines() {
        return numMines;
    }

    public void setNumMines(int numMines) {
        this.numMines = Math.max(numMines, MINMINES);
        this.numMines = Math.min(this.numMines, width*height - 1);
    }
}
