package lpoo.model.game;

public class EmptyTile extends Tile {
    private int adjacentMines;

    EmptyTile(int adjacentMines){
        super();
        this.adjacentMines = adjacentMines;
    }

    @Override
    public int getAdjacentMines() {
        return adjacentMines;
    }

    @Override
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
}
