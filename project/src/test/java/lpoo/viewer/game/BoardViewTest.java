package lpoo.viewer.game;

import lpoo.gui.GUI;
import lpoo.gui.LanternaGUI;
import lpoo.model.*;
import lpoo.model.game.Board;
import lpoo.model.game.Tile;
import lpoo.model.game.tilestate.TileState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.*;

public class BoardViewTest {

    @Test
    public void BoardView() throws IOException {
        GUI gui = Mockito.mock(LanternaGUI.class);

        Board board = Mockito.mock(Board.class);
        BoardView boardView = new BoardView(board);

        Tile tile = Mockito.mock(Tile.class);

        Mockito.when(board.getHeight()).thenReturn(2);
        Mockito.when(board.getWidth()).thenReturn(2);
        Mockito.when(board.getTileAtPosition(any())).thenReturn(tile);
        Mockito.when(tile.getStateName()).thenReturn(TileState.STATE.CLOSED);

        boardView.draw(new Position(1,3), gui);

        Mockito.verify(gui,Mockito.times(4)).drawString(anyString(), anyInt(), anyInt(), anyString());
    }

}
