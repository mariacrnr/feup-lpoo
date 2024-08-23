package lpoo.viewer.game;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.game.Timer;
import lpoo.model.menu.Frame;
import lpoo.viewer.FrameView;
import lpoo.viewer.View;

public class TimerView extends View<Timer> {

    public TimerView(Timer timer) {
        super(timer);
    }

    @Override
    public void drawElement(Position position, GUI gui) {
        Frame frame = new Frame(gui.terminalSize().getColumns(),0);

        String time = "time " + getModel().getTime();
        gui.drawString(time,gui.terminalSize().getColumns() - time.length() - 3,2, "#FFFFFF");

        new FrameView(frame).drawElement(new Position(0,Timer.TIMER_HEIGHT-1),gui);
    }
}
