package lpoo.gui;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class LanternaGUI implements GUI{
    private Screen screen;
    private TextGraphics graphics;
    private static final int DEFAULT_FONT_SIZE = 17;
    private boolean refreshAll;
    public static final int DEFAULT_COLS = 30;
    public static final int DEFAULT_ROWS = 20;


    public LanternaGUI(int width, int height){
        try{
            SwingTerminalFontConfiguration fontConfig = createFont();
            Terminal terminal = createTerminal(fontConfig, width, height);

            this.screen = createScreen(terminal);
            this.graphics = screen.newTextGraphics();

        }
        catch (IOException | FontFormatException | URISyntaxException e){
            e.printStackTrace();
        }
    }


    private Screen createScreen(Terminal terminal) throws IOException {
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        return screen;
    }

    private Terminal createTerminal(SwingTerminalFontConfiguration fontConfig, int width, int height) throws IOException{
        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setInitialTerminalSize(new TerminalSize(width, height));
        factory.setTerminalEmulatorFontConfiguration(fontConfig);

        return factory.createTerminal();
    }

    private SwingTerminalFontConfiguration createFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/CaffeineMono.otf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, DEFAULT_FONT_SIZE);

        return SwingTerminalFontConfiguration.newInstance(loadedFont);
    }


    @Override
    public void drawString(String string, int column, int row, String color) {

        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(column, row, string,SGR.BOLD);
    }

    @Override
    public void setTerminalBackgroundColor(String color){
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(0, 0), screen.getTerminalSize(), ' ');
    }

    @Override
    public void clear(){
        if(screen.doResizeIfNecessary() != null) refreshAll = true;
        screen.clear();
        setTerminalBackgroundColor("#05122D");
    }

    @Override
    public void refresh() throws IOException{
        screen.refresh((refreshAll ? Screen.RefreshType.COMPLETE : Screen.RefreshType.DELTA));
        refreshAll = false;
    }

    @Override
    public void close() throws IOException{
        screen.close();
    }

    @Override
    public Key getNextKey() throws IOException{
        KeyStroke keyStroke = screen.pollInput();

        if(keyStroke == null){
            return new Key(ACTION.NONE, null);
        }

        switch (keyStroke.getKeyType()){
            case ArrowDown:
                return new Key(ACTION.DOWN, null);
            case ArrowUp:
                return new Key(ACTION.UP, null);
            case ArrowRight:
                return new Key(ACTION.RIGHT, null);
            case ArrowLeft:
                return new Key(ACTION.LEFT, null);
            case EOF:
                return new Key(ACTION.QUIT, null);
            case Enter:
                return new Key(ACTION.SELECT, null);
            case Backspace:
                return new Key(ACTION.DELETE, null);
            case Escape:
                return new Key(ACTION.ESCAPE, null);
            case Character:
                switch(keyStroke.getCharacter()){
                    case 'a':
                        return new Key(ACTION.OPEN, 'a');
                    case 's':
                        return new Key(ACTION.FLAG, 's');
                    case 'z':
                        return new Key(ACTION.BACK, 'z');
                    default:
                        return new Key(ACTION.NONE, keyStroke.getCharacter());
                }
        }

        return new Key(ACTION.NONE, null);
    }

    @Override
    public int getWidthPos(int x) {
        return (screen.getTerminalSize().getColumns() - x) / 2;
    }

    @Override
    public int getHeightPos(int y) {
        return (screen.getTerminalSize().getRows() / 2) + y;
    }

    @Override
    public TerminalSize terminalSize(){
        return screen.getTerminalSize();
    }

    @Override
    public void paintSquare(int column, int row, String color){
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(column, row), new TerminalSize(1,1), ' ');
    }
}
