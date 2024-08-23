package lpoo.controller.settings;

import lpoo.Application;
import lpoo.controller.Controller;
import lpoo.gui.Key;
import lpoo.model.menu.Menu;
import lpoo.model.settings.SettingsMenu;
import lpoo.states.MenuState;

public class SettingsController extends Controller<SettingsMenu> {

    public SettingsController(SettingsMenu model) {
        super(model);
    }

    @Override
    public void step(Application application, Key key) {
        switch(key.getAction()){
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case LEFT:
                getModel().decrease();
                break;
            case RIGHT:
                getModel().increase();
                break;
            case SELECT:
                if(getModel().isSelectedBack()){
                    application.setState(new MenuState(new Menu(getModel().getConfiguration())));
                }
                break;
            case QUIT:
                application.setState(null);
                break;
        }
    }
}
