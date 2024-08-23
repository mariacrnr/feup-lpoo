package lpoo.states;

import lpoo.controller.Controller;
import lpoo.controller.menu.MenuController;
import lpoo.model.menu.Menu;
import lpoo.viewer.menu.MenuView;
import lpoo.viewer.View;

public class MenuState extends State<Menu> {
    public MenuState(Menu menu) {
        super(menu);
    }

    @Override
    protected View<Menu> getViewer() { return new MenuView(getModel()); }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
