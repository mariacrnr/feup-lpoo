package lpoo.viewer.menu;

import com.googlecode.lanterna.TerminalSize;
import lpoo.gui.GUI;
import lpoo.gui.LanternaGUI;
import lpoo.model.Position;
import lpoo.model.menu.Menu;
import lpoo.model.score.HighScore;
import lpoo.model.score.Ranking;
import lpoo.model.score.RankingMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankingViewTest {
    GUI gui;
    TerminalSize terminalSize;
    RankingMenu menu;
    RankingView rankingView;

    @BeforeEach
    public void rankingViewInit(){
        gui = Mockito.mock(GUI.class);
        terminalSize = Mockito.mock(TerminalSize.class);
        menu = Mockito.mock(RankingMenu.class);
        rankingView = new RankingView(menu);

        Mockito.when(gui.terminalSize()).thenReturn(terminalSize);
        Mockito.when(terminalSize.getColumns()).thenReturn(20);
        Mockito.when(terminalSize.getRows()).thenReturn(20);
        Mockito.when(gui.getWidthPos(4)).thenReturn(8);
        Mockito.when(gui.getWidthPos(5)).thenReturn(7);
        Mockito.when(gui.getWidthPos(12)).thenReturn(4);
        Mockito.when(gui.getHeightPos(5)).thenReturn(15);
        for (int i = 0; i < 3; i++)
            Mockito.when(gui.getHeightPos(i*2 - 2)).thenReturn(i*2 + 8);

        ArrayList<HighScore> highScoreList = new ArrayList<>();
        highScoreList.add(new HighScore("A", 40));
        highScoreList.add(new HighScore("B", 60));


        Ranking ranking = new Ranking();
        ranking.setHighScores(highScoreList);

        Mockito.when(rankingView.getModel().getRanking()).thenReturn(ranking);
    }

    @Test
    public void rankingViewStructure() {
        rankingView.drawElement(new Position(0, 0), gui);

        Mockito.verify(gui, Mockito.times(1)).drawString("name", 0,6, "#9BE564");
        Mockito.verify(gui, Mockito.times(1)).drawString("score", 16,6, "#9EC1CF");
        Mockito.verify(gui, Mockito.times(1)).drawString("back", 8,15, "#FFF200");

    }

    @Test
    public void rankingViewScore() {
        rankingView.drawElement(new Position(0, 0), gui);

        Mockito.verify(gui, Mockito.times(1)).drawString("A", 0,8, "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawString("40", 16,8, "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawString("B", 0,10, "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawString("60", 16,10, "#FFFFFF");

        Mockito.verify(gui, Mockito.times(1)).drawString("----", 0,12, "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawString("-----", 16,12, "#FFFFFF");
    }
}
