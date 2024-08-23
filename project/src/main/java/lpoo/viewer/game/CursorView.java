package lpoo.viewer.game;

import lpoo.gui.GUI;
import lpoo.model.game.Cursor;
import lpoo.model.Position;
import lpoo.viewer.View;

public class CursorView extends View<Cursor> {

    public CursorView(Cursor cursor) {
        super(cursor);
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        int cursorRows = position.getY() + getModel().getPosition().getX() * Cursor.CURSOR_HEIGHT_OFFSET;
        int cursorCols = position.getX() + getModel().getPosition().getY() *  Cursor.CURSOR_WIDTH_OFFSET;

        gui.drawString("<",cursorCols, cursorRows,"#FFFFFF");
        gui.drawString(">",cursorCols +  Cursor.CURSOR_HEIGHT_OFFSET, cursorRows,"#FFFFFF");
    }
}
