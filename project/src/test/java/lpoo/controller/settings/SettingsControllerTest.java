package lpoo.controller.settings;

import lpoo.Application;
import lpoo.gui.Key;
import lpoo.gui.GUI;
import lpoo.model.settings.SettingsMenu;
import lpoo.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class SettingsControllerTest {
    private SettingsMenu settingsMenu;
    private Application application;
    private SettingsController settingsController;

    @BeforeEach
    public void setup(){
        settingsMenu = Mockito.mock(SettingsMenu.class);
        application = Mockito.mock(Application.class);
        settingsController = new SettingsController(settingsMenu);
    }

    @Test
    public void actionsTest(){
        settingsController.step(application, new Key(GUI.ACTION.DOWN, null));
        Mockito.verify(settingsMenu, Mockito.times(1)).nextEntry();

        settingsController.step(application, new Key(GUI.ACTION.UP, null));
        Mockito.verify(settingsMenu, Mockito.times(1)).previousEntry();

        settingsController.step(application, new Key(GUI.ACTION.LEFT, null));
        Mockito.verify(settingsMenu, Mockito.times(1)).decrease();

        settingsController.step(application, new Key(GUI.ACTION.RIGHT, null));
        Mockito.verify(settingsMenu, Mockito.times(1)).increase();
    }

    @Test
    public void exitTest(){
        Mockito.when(settingsMenu.isSelectedBack()).thenReturn(true);

        settingsController.step(application, new Key(GUI.ACTION.SELECT, null));
        Mockito.verify(application, Mockito.times(1)).setState(any(MenuState.class));
    }
}
