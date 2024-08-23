package lpoo.viewer.game;

import lpoo.gui.GUI;
import lpoo.gui.LanternaGUI;
import lpoo.model.Position;
import lpoo.model.game.Tile;
import lpoo.model.game.tilestate.TileState;
import lpoo.viewer.game.TileView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class TileViewTest {
    @Test
    public void OpenTileView() throws IOException {
        GUI gui = Mockito.mock(LanternaGUI.class);
        Tile tile = Mockito.mock(Tile.class);
        for(int i = 0; i < 9; i++){
            Mockito.when(tile.getAdjacentMines()).thenReturn(i);
            Mockito.when(tile.getStateName()).thenReturn(TileState.STATE.OPEN);
            TileView tileView = new TileView(tile);
            tileView.draw(new Position(0,0), gui);

            Mockito.verify(gui,Mockito.times(1)).drawString(
                    String.valueOf(i), 0, 0, tileView.getColorsList().get(i));
        }
    }

    @Test
    public void FlaggedTileView() throws IOException {
        GUI gui = Mockito.mock(LanternaGUI.class);
        Tile tile = Mockito.mock(Tile.class);
        Mockito.when(tile.getStateName()).thenReturn(TileState.STATE.FLAGGED);
        TileView tileView = new TileView(tile);
        tileView.draw(new Position(2,4), gui);

        Mockito.verify(gui,Mockito.times(1)).drawString("!", 2, 4, "#FFF200");
    }

    @Test
    public void ClosedTileView() throws IOException {
        GUI gui = Mockito.mock(LanternaGUI.class);
        Tile tile = Mockito.mock(Tile.class);
        Mockito.when(tile.getStateName()).thenReturn(TileState.STATE.CLOSED);
        TileView tileView = new TileView(tile);
        tileView.draw(new Position(0,0), gui);

        Mockito.verify(gui,Mockito.times(1)).drawString("-", 0, 0, "#FFFFFF");
    }
}
