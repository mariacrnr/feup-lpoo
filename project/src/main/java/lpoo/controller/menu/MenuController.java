package lpoo.controller.menu;

import lpoo.Application;
import lpoo.controller.Controller;
import lpoo.gui.Key;
import lpoo.gui.LanternaGUI;
import lpoo.model.game.*;
import lpoo.model.menu.ControlsMenu;
import lpoo.model.menu.Menu;
import lpoo.model.score.RankingMenu;
import lpoo.model.settings.SettingsMenu;
import lpoo.states.ControlsState;
import lpoo.states.GameState;
import lpoo.states.RankingState;
import lpoo.states.SettingsState;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Application application, Key key){
        switch (key.getAction()) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) application.setState(null);
                if (getModel().isSelectedStart()) {
                    Board board = new BoardBuilder(getModel().getConfiguration()).generateBoard();
                    application.setState(new GameState(new Game(getModel().getConfiguration(),board)));

                    int terminalWidth = getModel().getConfiguration().getWidth()*Cursor.CURSOR_WIDTH_OFFSET +
                            2*Game.FRAME_OFFSET;
                    int terminalHeight = getModel().getConfiguration().getHeight()*Cursor.CURSOR_HEIGHT_OFFSET
                            + Timer.TIMER_HEIGHT + 2*Game.FRAME_OFFSET;

                    application.changeGUI(new LanternaGUI(terminalWidth, terminalHeight));
                }
                if(getModel().isSelectedSettings()) {
                    application.setState(new SettingsState(new SettingsMenu(getModel().getConfiguration())));
                }

                if(getModel().isSelectedHighscores()) {
                    application.setState(new RankingState(new RankingMenu(getModel().getConfiguration())));
                }
                if(getModel().isSelectedControls()) {
                    application.setState(new ControlsState(new ControlsMenu(getModel().getConfiguration())));
                }

                break;
            case QUIT:
                application.setState(null);
                break;
        }
    }
}