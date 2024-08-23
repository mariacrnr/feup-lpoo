package lpoo.controller.menu;

import lpoo.Application;
import lpoo.gui.Key;
import lpoo.gui.GUI;
import lpoo.model.menu.Menu;
import lpoo.states.RankingState;
import lpoo.states.SettingsState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class MenuControllerTest {
    private Menu menu;
    private Application application;
    private MenuController menuController;

    @BeforeEach
    public void setup(){
        menu = Mockito.mock(Menu.class);
        application = Mockito.mock(Application.class);
        menuController = new MenuController(menu);
    }

    @Test
    public void testMenuCursor(){
        menuController.step(application, new Key(GUI.ACTION.DOWN, null));
        menuController.step(application, new Key(GUI.ACTION.UP, null));

        Mockito.verify(menu, Mockito.times(1)).nextEntry();
        Mockito.verify(menu, Mockito.times(1)).previousEntry();
    }

    @Test
    public void testExitMenu() {
        Mockito.when(menu.isSelectedExit()).thenReturn(true);
        menuController.step(application, new Key(GUI.ACTION.SELECT, null));

        Mockito.verify(application, Mockito.times(1)).setState(null);
    }

    @Test
    public void testSettingsMenu() {
        Mockito.when(menu.isSelectedSettings()).thenReturn(true);
        menuController.step(application, new Key(GUI.ACTION.SELECT, null));

        Mockito.verify(application, Mockito.times(1)).setState(any(SettingsState.class));
    }

    @Test
    public void testHighScoresMenu() {
        Mockito.when(menu.isSelectedHighscores()).thenReturn(true);
        menuController.step(application, new Key(GUI.ACTION.SELECT, null));

        Mockito.verify(application, Mockito.times(1)).setState(any(RankingState.class));
    }
}
