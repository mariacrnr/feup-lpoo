package lpoo.controller.game;

import lpoo.controller.game.commands.FlagCommand;
import lpoo.controller.game.commands.OpenCommand;
import lpoo.model.Position;
import lpoo.model.game.Board;
import lpoo.model.game.Cursor;
import lpoo.model.game.Game;
import lpoo.model.game.Tile;
import lpoo.model.game.tilestate.ClosedState;
import lpoo.model.game.tilestate.TileState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class OpenTileTest {
    private Game game;
    private Tile tile;
    private Board board;
    private Cursor cursor;
    private TileState closedTileState;
    private TileState openTileState;

    @BeforeEach
    public void setup(){
        game = Mockito.mock(Game.class);
        tile = Mockito.mock(Tile.class);
        board = Mockito.mock(Board.class);
        cursor = Mockito.mock(Cursor.class);
        closedTileState = Mockito.mock(TileState.class);
        openTileState = Mockito.mock(TileState.class);

        Mockito.when(tile.getState()).thenReturn(closedTileState);
        Mockito.when(closedTileState.open()).thenReturn(openTileState);
        Mockito.when(tile.getStateName()).thenReturn(TileState.STATE.CLOSED);
        Mockito.when(game.getBoard()).thenReturn(board);
        Mockito.when(board.getRemainingTiles()).thenReturn(2);
        Mockito.when(game.getCursor()).thenReturn(cursor);
        Mockito.when(cursor.getPosition()).thenReturn(new Position(0,0));
        Mockito.when(board.getTileAtPosition(any())).thenReturn(tile);
    }

    @Test
    public void openTile(){
        new OpenCommand(game).execute();
        Mockito.verify(closedTileState, Mockito.times(1)).open();
        Mockito.verify(tile, Mockito.times(1)).setState(openTileState);
        Mockito.verify(board, Mockito.times(1)).setRemainingTiles(1);
    }

    @Test
    public void undoOpenTile(){
        OpenCommand openCommand = new OpenCommand(game);
        openCommand.execute();
        openCommand.undo();
        Mockito.verify(tile, Mockito.times(2)).setState(any());
        Mockito.verify(board, Mockito.times(1)).setRemainingTiles(3);
    }

    @Test
    public void undoOpenTileEmpty(){
        new OpenCommand(game).undo();
        Mockito.verify(tile, Mockito.times(0)).setState(any());
    }
}
