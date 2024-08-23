package lpoo.viewer.game;

import com.googlecode.lanterna.TerminalSize;
import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.game.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class TimerViewTest {
    GUI gui;
    Timer timer;
    TimerView timerView;
    TerminalSize terminalSize;

    @BeforeEach
    public void timerViewInit(){
        gui = Mockito.mock(GUI.class);
        terminalSize = Mockito.mock(TerminalSize.class);
        timer = Mockito.mock(Timer.class);
        timerView = new TimerView(timer);

        Mockito.when(gui.terminalSize()).thenReturn(terminalSize);
        Mockito.when(terminalSize.getColumns()).thenReturn(20);

    }

    @Test
    public void timerView(){

        timerView.drawElement(new Position(0, 0), gui);

        Mockito.verify(gui,Mockito.times(1)).drawString("time 0",
                11, 2, "#FFFFFF");
    }
}
