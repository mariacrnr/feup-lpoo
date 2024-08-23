package lpoo.viewer.game;

import lpoo.gui.GUI;
import lpoo.model.game.Board;
import lpoo.model.Position;
import lpoo.viewer.View;

public class BoardView extends View<Board> {

    public BoardView(Board board) {
        super(board);
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        TileView tileView;
        Board board = getModel();
        Position tilePosition, tileScreenPosition;

        for(int line = 0; line < board.getHeight(); line++){
            for(int column = 0; column < board.getWidth(); column++){

                tilePosition = new Position(line,column);
                tileScreenPosition = new Position(column * 3 + position.getX() + 1, line * 2 + position.getY());

                tileView = new TileView(board.getTileAtPosition(tilePosition));
                tileView.drawElement(tileScreenPosition, gui);
            }
        }
    }
}
