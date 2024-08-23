package lpoo.states;

import lpoo.controller.Controller;
import lpoo.controller.menu.ControlsController;
import lpoo.model.menu.ControlsMenu;
import lpoo.viewer.View;
import lpoo.viewer.menu.ControlsView;


public class ControlsState extends State<ControlsMenu> {
    public ControlsState(ControlsMenu model) {
        super(model);
    }

    @Override
    protected View<ControlsMenu> getViewer() {
        return new ControlsView(getModel());
    }

    @Override
    protected Controller<ControlsMenu> getController() {
        return new ControlsController(getModel());
    }
}
