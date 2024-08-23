package lpoo.states;

import lpoo.controller.Controller;
import lpoo.controller.settings.SettingsController;
import lpoo.model.settings.SettingsMenu;
import lpoo.viewer.View;
import lpoo.viewer.menu.SettingsView;

public class SettingsState extends State<SettingsMenu> {
    public SettingsState(SettingsMenu model) {
        super(model);
    }

    @Override
    protected View<SettingsMenu> getViewer() {
        return new SettingsView(getModel());
    }

    @Override
    protected Controller<SettingsMenu> getController() {
        return new SettingsController(getModel());
    }
}
