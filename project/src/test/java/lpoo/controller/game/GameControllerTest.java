package lpoo.controller.game;

import lpoo.Application;
import lpoo.controller.game.commands.*;
import lpoo.gui.Key;
import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.game.Board;
import lpoo.model.game.Cursor;
import lpoo.model.game.Game;
import lpoo.model.game.Tile;
import lpoo.model.game.tilestate.TileState;
import lpoo.states.GameOverState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class GameControllerTest {
    private Game game;
    private Application application;
    private Tile tile;
    private Board board;
    private GameController gameController;

    @BeforeEach
    public void setup(){
        game = Mockito.mock(Game.class);
        application = Mockito.mock(Application.class);
        tile = Mockito.mock(Tile.class);
        board = Mockito.mock(Board.class);
        gameController = Mockito.spy(new GameController(game));

        Mockito.when(game.getBoard()).thenReturn(board);
        Mockito.when(board.getRemainingTiles()).thenReturn(3);
        Mockito.when(game.selectedTile()).thenReturn(tile);
        Mockito.when(tile.getAdjacentMines()).thenReturn(3);
    }

    @Test
    public void testGameQuit(){
        gameController.step(application, new Key(GUI.ACTION.QUIT, null));
        Mockito.verify(application, Mockito.times(1)).setState(null);
    }

    @Test
    public void testFlag(){
        TileState tileState = Mockito.mock(TileState.class);

        Mockito.when(tile.getState()).thenReturn(tileState);

        gameController.step(application, new Key(GUI.ACTION.FLAG, null));
        Mockito.verify(gameController, Mockito.times(1)).executeCommand(any(FlagCommand.class));
    }

    @Test
    public void testMove(){
        Cursor cursor = Mockito.mock(Cursor.class);
        Position position = Mockito.mock(Position.class);
        Mockito.when(game.getCursor()).thenReturn(cursor);
        Mockito.when(cursor.getPosition()).thenReturn(position);

        gameController.step(application, new Key(GUI.ACTION.UP, null));
        Mockito.verify(gameController, Mockito.times(1)).executeCommand(any(MoveUpCommand.class));
        gameController.step(application, new Key(GUI.ACTION.RIGHT,null));
        Mockito.verify(gameController, Mockito.times(1)).executeCommand(any(MoveRightCommand.class));
        gameController.step(application, new Key(GUI.ACTION.LEFT,null));
        Mockito.verify(gameController, Mockito.times(1)).executeCommand(any(MoveLeftCommand.class));
        gameController.step(application, new Key(GUI.ACTION.DOWN,null));
        Mockito.verify(gameController, Mockito.times(1)).executeCommand(any(MoveDownCommand.class));
    }

    @Test
    public void testGameOver(){
        Mockito.when(board.getRemainingTiles()).thenReturn(0);
        Mockito.when(tile.getAdjacentMines()).thenReturn(-1);
        Mockito.when(tile.getStateName()).thenReturn(TileState.STATE.OPEN);

        gameController.step(application, new Key(GUI.ACTION.NONE, null));
        Mockito.verify(application, Mockito.times(2)).setState(any(GameOverState.class));
    }


}
