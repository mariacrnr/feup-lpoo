package lpoo.viewer.menu;

import com.googlecode.lanterna.TerminalSize;
import lpoo.gui.GUI;
import lpoo.gui.LanternaGUI;
import lpoo.model.Position;
import lpoo.model.game.Timer;
import lpoo.model.menu.ControlsMenu;
import lpoo.model.menu.Frame;
import lpoo.viewer.FrameView;
import lpoo.viewer.game.TimerView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;

public class ControlsViewTest {
    private GUI gui;
    private ControlsMenu menu;
    private ControlsView controlsView;
    private TerminalSize terminalSize;

    @BeforeEach
    public void controlsViewInit(){
        gui = Mockito.mock(GUI.class);
        terminalSize = Mockito.mock(TerminalSize.class);
        menu = Mockito.mock(ControlsMenu.class);
        controlsView = new ControlsView(menu);

        Mockito.when(gui.terminalSize()).thenReturn(terminalSize);
        Mockito.when(terminalSize.getColumns()).thenReturn(20);
        Mockito.when(terminalSize.getRows()).thenReturn(20);
        Mockito.when(controlsView.getModel().getControls()).thenReturn(Arrays.asList("A", "S", "Z", "esc","arrows", "enter"));
        Mockito.when(controlsView.getModel().getDescription()).thenReturn(Arrays.asList("select tile", "flag & unflag", "undo move", "back to menu", "move cursor", "menu select"));
        for(int i = 0; i < 6; i++){
            Mockito.when(gui.getHeightPos(2*i-5)).thenReturn(2*i + 5);
        }
    }

    @Test
    public void controlsViewStructure(){
        controlsView.drawElement(new Position(0, 0), gui);
        Mockito.verify(gui,Mockito.times(1)).drawString("select tile", 14, 5, "#FFFFFF");
        Mockito.verify(gui,Mockito.times(1)).drawString("flag & unflag", 14, 7, "#FFFFFF");
        Mockito.verify(gui,Mockito.times(1)).drawString("undo move", 14, 9, "#FFFFFF");
        Mockito.verify(gui,Mockito.times(1)).drawString("back to menu", 14, 11, "#FFFFFF");
        Mockito.verify(gui,Mockito.times(1)).drawString("move cursor", 14, 13, "#FFFFFF");
        Mockito.verify(gui,Mockito.times(1)).drawString("menu select", 14, 15, "#FFFFFF");

        Mockito.verify(gui,Mockito.times(1)).drawString("A", 5, 5, "#9EC1CF");
        Mockito.verify(gui,Mockito.times(1)).drawString("S", 5, 7, "#CC99C9");
        Mockito.verify(gui,Mockito.times(1)).drawString("Z", 5, 9, "#9EC1CF");
        Mockito.verify(gui,Mockito.times(1)).drawString("esc", 5, 11, "#9BE564");
        Mockito.verify(gui,Mockito.times(1)).drawString("arrows", 5, 13, "#FDFD97");
        Mockito.verify(gui,Mockito.times(1)).drawString("enter", 5, 15, "#FEB144");
    }
}
