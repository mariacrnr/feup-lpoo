package lpoo.model;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Position getLeft() {
        return new Position(x , y - 1);
    }

    public Position getRight() {
        return new Position(x, y + 1);
    }

    public Position getUp() {
        return new Position(x - 1, y);
    }

    public Position getDown() {
        return new Position(x + 1, y);
    }


}
