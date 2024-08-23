import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.Random;

public class Monster extends Element{
    Monster(int x, int y){
        super(x,y);
    }

    public Position move(){
        int x = new Random().nextBoolean() ? this.getPosition().getX()+1: this.getPosition().getX()-1;
        int y = new Random().nextBoolean() ? this.getPosition().getY()+1: this.getPosition().getY()-1;
        return new Position(x,y);
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#98CE00"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "S");
    }

}
