package lpoo.model.game;

import lpoo.model.Configuration;

import java.util.Random;

public class BoardBuilder {
    private final Random rng;

    private final int height;
    private final int width;
    private final int numMines;

    public BoardBuilder(Configuration configuration){
        this.rng = new Random();
        this.height = configuration.getHeight();
        this.width = configuration.getWidth();
        this.numMines = configuration.getNumMines();
    }

    public Board generateBoard(){
        Board board = new Board(height, width);
        Tile[][] tiles = generateEmptyTiles();
        generateMines(tiles);
        board.setBoard(tiles);
        board.setRemainingTiles(height*width - numMines);
        return board;
    }

    private void generateMines(Tile[][] tiles){
        int placedMines = 0;
        while(placedMines < numMines){
            int x = rng.nextInt(height);
            int y = rng.nextInt(width);
            if(tiles[x][y].getAdjacentMines() != -1){
                tiles[x][y] = new MinedTile();
                updateAdjacentTiles(x,y, tiles);
                placedMines++;
            }
        }
    }

    private Tile[][] generateEmptyTiles(){
        Tile[][] tiles = new Tile[height][width];
        for(int line = 0; line < height; line++){
            for(int col = 0; col < width; col++){
                tiles[line][col] = new EmptyTile(0);
            }
        }
        return tiles;
    }

    private void updateAdjacentTiles(int x,int y, Tile[][] tiles){
        for(int line = Math.max(0, x - 1); line < Math.min(height, x + 2); line++){
            for(int col = Math.max(0, y - 1); col < Math.min(width, y + 2); col++){
                tiles[line][col].setAdjacentMines(tiles[line][col].getAdjacentMines() + 1);
            }
        }
    }
}
