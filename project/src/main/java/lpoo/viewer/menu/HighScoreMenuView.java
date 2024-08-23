package lpoo.viewer.menu;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.menu.Frame;
import lpoo.model.score.HighScoreMenu;
import lpoo.model.score.HighScore;
import lpoo.viewer.FrameView;
import lpoo.viewer.View;

public class HighScoreMenuView extends View<HighScoreMenu> {
    public HighScoreMenuView(HighScoreMenu model) {
        super(model);
    }

    private void drawNewHighscore(GUI gui, int center){
        gui.drawString("hello, i'm ...", center , gui.getHeightPos(-TITLE_ROW), "#FFFFFF");

        gui.drawString(getModel().getUsername(), center + 2, gui.getHeightPos(0), "#FFFFFF");

        String continueMessage = "continue";
        gui.drawString(continueMessage, gui.getWidthPos(continueMessage.length()),
                gui.getHeightPos(TITLE_ROW+2),"#FFF200");
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        gui.setTerminalBackgroundColor("#05122D");

        Frame frame = new Frame(gui.terminalSize().getColumns(), gui.terminalSize().getRows());
        Frame lineFrame = new Frame(HighScore.MAX_LENGTH,0);

        int center = drawMultiColoredTitle(gui,"new highscore!", TITLE_ROW);

        drawNewHighscore(gui,center);

        new FrameView(lineFrame).drawElement(new Position(center + 2, gui.getHeightPos(1)), gui);
        new FrameView(frame).drawElement(new Position(0,0), gui);
    }
}
