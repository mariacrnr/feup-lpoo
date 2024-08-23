package lpoo.viewer.menu;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.menu.Frame;
import lpoo.model.settings.SettingsMenu;
import lpoo.viewer.FrameView;
import lpoo.viewer.View;

public class SettingsView extends View<SettingsMenu> {

    public SettingsView(SettingsMenu settings) {
        super(settings);
    }

    private void drawSettings(GUI gui, int col){
        for(int i = 0; i < getModel().getNumberEntries()-1; i++){
            gui.drawString(getModel().getEntry(i), col, gui.getHeightPos(i * 2 - 3), "#FFFFFF");
            gui.drawString(getModel().getConfigurationValue(i),
                    col + 19, gui.getHeightPos(i*2 - 3), "#FFFFFF" );
            if(getModel().getSelected(i)) {
                gui.drawString("<", col + 17, gui.getHeightPos(i * 2 - 3), "#FFF200");
                gui.drawString(">", col + 22, gui.getHeightPos(i * 2 - 3), "#FFF200");
            }
        }
        gui.drawString(getModel().getEntry(3), col, gui.getHeightPos(3),
                (getModel().getSelected(3)) ? "#FFF200" :"#FFFFFF");
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        gui.setTerminalBackgroundColor("#05122D");

        Frame frame = new Frame(gui.terminalSize().getColumns(), gui.terminalSize().getRows());

        drawMultiColoredTitle(gui,"settings.",TITLE_ROW);
        drawSettings(gui,4);

        new FrameView(frame).drawElement(new Position(0,0), gui);
    }
}