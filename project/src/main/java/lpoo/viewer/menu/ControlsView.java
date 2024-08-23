package lpoo.viewer.menu;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.menu.ControlsMenu;
import lpoo.model.menu.Frame;
import lpoo.viewer.FrameView;
import lpoo.viewer.View;

import java.util.List;

public class ControlsView extends View<ControlsMenu> {
    public ControlsView(ControlsMenu controls) {
        super(controls);
    }

    protected void drawControls(GUI gui, int col) {
        List<String> controls = getModel().getControls();
        List<String> description = getModel().getDescription();

        for (int i = 0; i < controls.size(); i++){
            gui.drawString(controls.get(i), col, gui.getHeightPos(i * 2 - 5),getColor(i));
            gui.drawString(description.get(i), col + 9, gui.getHeightPos(i * 2 - 5),"#FFFFFF");
        }
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        gui.setTerminalBackgroundColor("#05122D");

        Frame frame = new Frame(gui.terminalSize().getColumns(), gui.terminalSize().getRows());

        String controls = "controls.";
        drawMultiColoredTitle(gui,controls,TITLE_ROW);

        drawControls(gui,5);

        String backMessage = "back";
        gui.drawString(backMessage, gui.getWidthPos(backMessage.length()),
                gui.getHeightPos(TITLE_ROW+4),"#FFF200");

        new FrameView(frame).drawElement(new Position(0,0), gui);
    }

}
