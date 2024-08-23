package lpoo.viewer.menu;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.menu.Frame;
import lpoo.model.score.RankingMenu;
import lpoo.model.score.Ranking;
import lpoo.viewer.FrameView;
import lpoo.viewer.View;

public class RankingView extends View<RankingMenu> {
    public RankingView(RankingMenu ranking) {
        super(ranking);
    }

    private void drawRanking(GUI gui, int center, String highScoreTitle){

        String nameTitle = "name";
        int nameCol = center - nameTitle.length();
        gui.drawString(nameTitle, nameCol,TITLE_ROW + 3,getColor(3));

        String scoreTitle = "score";
        int scoreCol = center + highScoreTitle.length();
        gui.drawString(scoreTitle, scoreCol,TITLE_ROW + 3,getColor(0));

        drawScores(gui, nameCol, scoreCol);

    }

    private void drawScores(GUI gui, int nameCol, int scoreCol){
        String name, score;
        Ranking ranking = getModel().getRanking();
        for (int i = 0; i < ranking.getMaxSize(); i++){
            if (i < ranking.getHighScores().size()) {
                name = ranking.getHighScores().get(i).getUsername();
                score = String.valueOf(ranking.getHighScores().get(i).getScore());
            }
            else {
                name = "----";
                score = "-----";
            }
            gui.drawString(name, nameCol,
                    gui.getHeightPos(i * 2 - 2),"#FFFFFF");
            gui.drawString(score, scoreCol,
                    gui.getHeightPos(i * 2 - 2), "#FFFFFF");
        }

    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        gui.setTerminalBackgroundColor("#05122D");

        Frame frame = new Frame(gui.terminalSize().getColumns(), gui.terminalSize().getRows());

        String highScoreTitle = " highscores.";
        int center = drawMultiColoredTitle(gui,highScoreTitle,TITLE_ROW);

        drawRanking(gui, center, highScoreTitle);

        String backMessage = "back";
        gui.drawString(backMessage, gui.getWidthPos(backMessage.length()),
                gui.getHeightPos(TITLE_ROW+2),"#FFF200");

        new FrameView(frame).drawElement(new Position(0,0), gui);
    }
}
