package lpoo.viewer.menu;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.menu.Frame;
import lpoo.model.menu.Menu;
import lpoo.viewer.FrameView;
import lpoo.viewer.View;

public class MenuView extends View<Menu> {

    public MenuView(Menu menu) {
        super(menu);
    }


    private void drawButtons(GUI gui, int center){
        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawString(getModel().getEntry(i), center, gui.getHeightPos(i*2 - 3),
                    getModel().isSelected(i) ? "#FFF200" :"#FFFFFF");
        }
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        gui.setTerminalBackgroundColor("#05122D");

        Frame frame = new Frame(gui.terminalSize().getColumns(), gui.terminalSize().getRows());

        int center = drawMultiColoredTitle(gui,"minesweeper.",TITLE_ROW);
        drawButtons(gui, center);

        new FrameView(frame).drawElement(new Position(0,0), gui);
    }
}
