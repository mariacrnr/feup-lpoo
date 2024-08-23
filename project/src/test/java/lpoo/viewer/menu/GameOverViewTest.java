package lpoo.viewer.menu;

import com.googlecode.lanterna.TerminalSize;
import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.score.GameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class GameOverViewTest {
    GUI gui;
    GameOverMenu menu;
    GameOverView gameOverView;
    TerminalSize terminalSize;

    @BeforeEach
    public void gameOverViewInit(){
        gui = Mockito.mock(GUI.class);
        terminalSize = Mockito.mock(TerminalSize.class);
        menu = Mockito.mock(GameOverMenu.class);
        gameOverView = new GameOverView(menu);

        Mockito.when(gui.terminalSize()).thenReturn(terminalSize);
        Mockito.when(terminalSize.getColumns()).thenReturn(20);
        Mockito.when(terminalSize.getRows()).thenReturn(20);
        Mockito.when(gameOverView.getModel().isWin()).thenReturn(true);
        Mockito.when(gameOverView.getModel().getScore()).thenReturn(150);
        Mockito.when(gui.getHeightPos(-1)).thenReturn(9);
        Mockito.when(gui.getHeightPos(-5)).thenReturn(5);
        Mockito.when(gui.getHeightPos(5)).thenReturn(15);
        Mockito.when(gui.getWidthPos(8)).thenReturn(12);
        Mockito.when(gameOverView.getModel().getScore()).thenReturn(150);
    }

    @Test
    public void gameOverViewScore(){

        gameOverView.drawScore(gui, 10);

        Mockito.verify(gui,Mockito.times(1)).drawString("score ", 10, 9, "#FF6663");
        Mockito.verify(gui, Mockito.times(1)).drawString("150", 18, 9, "#FFFFFF");

    }

    @Test
    public void gameOverViewContinue(){
        gameOverView.drawElement(new Position(0, 0), gui);

        Mockito.verify(gui, Mockito.times(1)).drawString("continue", 12, 15,"#FFF200");
    }
}
