package lpoo.model.game;

import lpoo.model.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardBuilderTest {
    @Test
    public void numMines(){
        Configuration configuration = new Configuration(20, 20, 30);
        BoardBuilder builder = new BoardBuilder(configuration);
        Board board = builder.generateBoard();

        Tile[][] tiles = board.getBoard();

        int count = 0;
        for (int i = 0; i < board.getHeight(); i++){
            for (int j = 0; j < board.getWidth(); j++){
                if (tiles[i][j].getClass() == MinedTile.class) count++;
            }
        }

        Assertions.assertEquals(30, count);
    }

    @Test
    public void adjacentTilesTest(){
        Configuration configuration = new Configuration(20, 20, 30);
        BoardBuilder builder = new BoardBuilder(configuration);
        Board board = builder.generateBoard();

        Tile[][] tiles = board.getBoard();

        for (int i = 0; i < board.getHeight(); i++){
            for (int j = 0; j < board.getWidth(); j++){

                if (tiles[i][j].getAdjacentMines() != -1) {
                    int count = 0;

                    for(int line = Math.max(0, i - 1); line < Math.min(board.getHeight(), i + 2); line++){
                        for(int col = Math.max(0, j - 1); col < Math.min(board.getWidth(), j + 2); col++){
                            if (tiles[line][col].getClass() == MinedTile.class) count++;
                        }
                    }

                    Assertions.assertEquals(tiles[i][j].getAdjacentMines(), count);
                }

            }
        }
    }
}
