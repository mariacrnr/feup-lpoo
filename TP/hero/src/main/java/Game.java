import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    private Screen screen;
    private Arena arena;


    Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary(); // resize screen if necessary

            this.arena = new Arena(40,20);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        this.arena.draw(screen.newTextGraphics());
        this.screen.refresh();
    }

    public void run(){
        try {
            while(true){
                draw();
                KeyStroke key = this.screen.readInput();
                if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                    this.screen.close();
                    break;
                }
                if(key.getKeyType() == KeyType.EOF) break;
                if(arena.verifyMonsterCollisions()) {
                    this.screen.close();
                    System.out.println("GAME OVER :(");
                    break;
                }
                processKey(key);
                if(arena.verifyMonsterCollisions()) {
                    this.screen.close();
                    System.out.println("GAME OVER :(");
                    break;
                }
                if(arena.getCoins().isEmpty()){
                    this.screen.close();
                    System.out.println("YOU WON :)");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void moveHero(Position position){
        this.arena.moveHero(position);
    }

    private void processKey(KeyStroke key){
        this.arena.processKey(key);
    }
}
