package lpoo.model.game;

import lpoo.model.Element;
import lpoo.model.Position;

public class Cursor implements Element {
    Position position;
    private final int height;
    private final int width;
    public static final int CURSOR_WIDTH_OFFSET = 3;
    public static final int CURSOR_HEIGHT_OFFSET = 2;

    public Cursor(int x, int y, int height, int width){
        this.position = new Position(x,y);
        this.height = height;
        this.width = width;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        int x = (position.getX() + height) % height;
        int y = (position.getY() + width) % width;
        this.position = new Position(x, y);
    }
}
