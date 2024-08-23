package lpoo.model.game;


public class MinedTile extends Tile {

    @Override
    public int getAdjacentMines() {
        return -1;
    }

    @Override
    public void setAdjacentMines(int adjacentMines) {}
}
