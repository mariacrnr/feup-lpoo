package lpoo.gui;

import com.googlecode.lanterna.TerminalSize;

import java.io.IOException;

public interface GUI {


    void drawString(String string, int column, int row, String color);

    void paintSquare(int column, int row, String color);

    void setTerminalBackgroundColor(String color);

    int getWidthPos(int x);

    int getHeightPos(int y);

    TerminalSize terminalSize();

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    Key getNextKey() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, FLAG, OPEN, QUIT, NONE, BACK, SELECT, DELETE, ESCAPE}

}
