package lpoo.viewer.menu;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.menu.Frame;
import lpoo.model.score.GameOverMenu;
import lpoo.viewer.FrameView;
import lpoo.viewer.View;

public class GameOverView extends View<GameOverMenu> {
    public GameOverView(GameOverMenu model) {
        super(model);
    }

    public void drawScore(GUI gui, int center){
        int score = getModel().getScore();
        gui.drawString("score ",center, gui.getHeightPos(-1),getColor(score));
        gui.drawString(String.valueOf(score),
                center+8,gui.getHeightPos(-1), "#FFFFFF");
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        gui.setTerminalBackgroundColor("#05122D");

        Frame frame = new Frame(gui.terminalSize().getColumns(), gui.terminalSize().getRows());

        if(getModel().isWin()) {
            int center = drawMultiColoredTitle(gui,"you won :)",gui.getHeightPos(-5));
            drawScore(gui,center);
        }
        else drawMultiColoredTitle(gui," you lost :(",gui.getHeightPos(-5));

        String continueMessage = "continue";
        gui.drawString(continueMessage, gui.getWidthPos(continueMessage.length()),
                gui.getHeightPos(TITLE_ROW+2),"#FFF200");

        new FrameView(frame).drawElement(new Position(0,0), gui);
    }
}
