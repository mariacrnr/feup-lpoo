package lpoo.viewer.game;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.game.Board;
import lpoo.model.game.Cursor;
import lpoo.model.game.Game;
import lpoo.model.game.Timer;
import lpoo.model.menu.Frame;
import lpoo.viewer.FrameView;
import lpoo.viewer.View;

public class GameView extends View<Game> {
    public GameView(Game game){
        super(game);
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        gui.setTerminalBackgroundColor("#05122D");

        Frame frame = new Frame(gui.terminalSize().getColumns(), gui.terminalSize().getRows());

        Position boardPosition = new Position(position.getX() + Game.FRAME_OFFSET,
                position.getY() + Timer.TIMER_HEIGHT + Game.FRAME_OFFSET);

        Timer timer = getModel().getTimer();
        Board board = getModel().getBoard();
        Cursor cursor = getModel().getCursor();

        String mines = "tiles " + board.getRemainingTiles();
        gui.drawString(mines,Game.FRAME_OFFSET ,Game.FRAME_OFFSET, "#FFFFFF");

        new BoardView(board).drawElement(boardPosition, gui);
        new CursorView(cursor).drawElement(boardPosition, gui);
        new TimerView(timer).drawElement(position,gui);

        new FrameView(frame).drawElement(new Position(0,0), gui);
    }

}
