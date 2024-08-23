package lpoo.viewer.menu;

import com.googlecode.lanterna.TerminalSize;
import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.score.HighScoreMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HighScoreViewTest {
    GUI gui;
    HighScoreMenu menu;
    HighScoreMenuView highScoreMenuView;
    TerminalSize terminalSize;

    @BeforeEach
    public void highScoreViewInit(){
        gui = Mockito.mock(GUI.class);
        terminalSize = Mockito.mock(TerminalSize.class);
        menu = Mockito.mock(HighScoreMenu.class);
        highScoreMenuView = new HighScoreMenuView(menu);

        Mockito.when(gui.terminalSize()).thenReturn(terminalSize);
        Mockito.when(terminalSize.getColumns()).thenReturn(20);
        Mockito.when(terminalSize.getRows()).thenReturn(20);
        Mockito.when(highScoreMenuView.getModel().getUsername()).thenReturn("a");
        Mockito.when(gui.getHeightPos(-3)).thenReturn(7);
        Mockito.when(gui.getHeightPos(0)).thenReturn(10);
        Mockito.when(gui.getHeightPos(1)).thenReturn(11);
        Mockito.when(gui.getHeightPos(5)).thenReturn(15);
        Mockito.when(gui.getWidthPos(8)).thenReturn(12);
        Mockito.when(gui.getWidthPos(14)).thenReturn(3);
    }

    @Test
    public void highScoreView(){

        highScoreMenuView.drawElement(new Position(0, 0), gui);

        Mockito.verify(gui, Mockito.times(1)).drawString("hello, i'm ...", 3 , 7, "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawString("a", 5 , 10, "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawString("continue", 12 , 15, "#FFF200");

    }
}
