package lpoo.viewer.menu;

import com.googlecode.lanterna.TerminalSize;
import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class MenuViewTest {
    GUI gui;
    Menu menu;
    MenuView menuView;
    TerminalSize terminalSize;

    @BeforeEach
    public void menuViewInit(){
        gui = Mockito.mock(GUI.class);
        terminalSize = Mockito.mock(TerminalSize.class);
        menu = Mockito.mock(Menu.class);
        menuView = new MenuView(menu);

        Mockito.when(gui.terminalSize()).thenReturn(terminalSize);
        Mockito.when(terminalSize.getColumns()).thenReturn(20);
        Mockito.when(terminalSize.getRows()).thenReturn(20);
        Mockito.when(menuView.getModel().isSelected(1)).thenReturn(true);
        Mockito.when(menuView.getModel().getNumberEntries()).thenReturn(3);
        Mockito.when(menuView.getModel().getEntry(0)).thenReturn("play");
        Mockito.when(menuView.getModel().getEntry(1)).thenReturn("option");
        Mockito.when(menuView.getModel().getEntry(2)).thenReturn("exit");
        Mockito.when(gui.getWidthPos(12)).thenReturn(4);
        for (int i = 0; i < 3; i++)
            Mockito.when(gui.getHeightPos(2*i-3)).thenReturn(2*i+ 7);
    }

    @Test
    public void menuView(){

        menuView.drawElement(new Position(0, 0), gui);

        Mockito.verify(gui, Mockito.times(1)).drawString("play", 4, 7, "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawString("option", 4, 9, "#FFF200");
        Mockito.verify(gui, Mockito.times(1)).drawString("exit", 4, 11, "#FFFFFF");

    }


}
