package lpoo.model.game;

import lpoo.model.Element;
import lpoo.model.Position;

public class Board implements Element {
    private int height, width;
    private Tile[][] tiles;
    private int remainingTiles;

    public Board(int height, int width){
        this.height = height;
        this.width = width;
        tiles = new Tile[height][width];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tile[][] getBoard() {
        return tiles;
    }

    public Tile getTileAtPosition(Position position){
        return tiles[position.getX()][position.getY()];
    }

    public void setTileAtPosition(Position position, Tile tile){
        tiles[position.getX()][position.getY()] = tile;
    }

    public void setBoard(Tile[][] board) {
        this.tiles = board;
    }

    public int getRemainingTiles() {
        return remainingTiles;
    }

    public void setRemainingTiles(int remainingTiles) {
        this.remainingTiles = remainingTiles;
    }
}
