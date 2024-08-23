package lpoo.controller.menu;

import lpoo.Application;
import lpoo.controller.Controller;
import lpoo.gui.Key;
import lpoo.gui.GUI;
import lpoo.model.menu.ControlsMenu;
import lpoo.model.menu.Menu;
import lpoo.states.MenuState;

public class ControlsController extends Controller<ControlsMenu> {

    public ControlsController(ControlsMenu control) {
        super(control);
    }

    @Override
    public void step(Application application, Key key) {
        if(key.getAction() == GUI.ACTION.SELECT){
            application.setState(new MenuState(new Menu(getModel().getConfiguration())));
        }
    }
}
