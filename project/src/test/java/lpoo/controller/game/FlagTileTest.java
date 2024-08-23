package lpoo.controller.game;

import lpoo.controller.game.commands.FlagCommand;
import lpoo.model.game.Game;
import lpoo.model.game.Tile;
import lpoo.model.game.tilestate.TileState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class FlagTileTest {

    @Test
    public void flagTile(){
        Game game = Mockito.mock(Game.class);
        Tile tile = Mockito.mock(Tile.class);
        TileState tileState = Mockito.mock(TileState.class);
        Mockito.when(game.selectedTile()).thenReturn(tile);
        Mockito.when(tile.getState()).thenReturn(tileState);

        new FlagCommand(game).execute();
        Mockito.verify(tileState, Mockito.times(1)).flag();
        Mockito.verify(tile, Mockito.times(1)).setState(any());
    }
}
