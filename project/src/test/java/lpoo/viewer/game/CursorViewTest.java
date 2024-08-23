package lpoo.viewer.game;

import lpoo.gui.GUI;
import lpoo.gui.LanternaGUI;
import lpoo.model.Position;
import lpoo.model.game.Cursor;
import lpoo.viewer.game.CursorView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class CursorViewTest {

    @Test
    public void CursorView() throws IOException {
        GUI gui = Mockito.mock(LanternaGUI.class);
        Cursor cursor = Mockito.mock(Cursor.class);

        Mockito.when(cursor.getPosition()).thenReturn(new Position(3,3));
        CursorView cursorView = new CursorView(cursor);
        cursorView.draw(new Position(2,1), gui);

        Mockito.verify(gui,Mockito.times(1)).drawString("<", 11, 7, "#FFFFFF");
        Mockito.verify(gui,Mockito.times(1)).drawString(">", 13, 7, "#FFFFFF");
    }
}
