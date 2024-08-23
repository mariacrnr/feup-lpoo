package lpoo.model.settings;

import lpoo.model.Configuration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SettingsMenuTest {
    @Test
    public void testSettings(){
        Configuration configuration = Mockito.mock(Configuration.class);
        Mockito.when(configuration.getHeight()).thenReturn(15);
        Mockito.when(configuration.getWidth()).thenReturn(15);
        Mockito.when(configuration.getNumMines()).thenReturn(15);

        SettingsMenu settingsMenu = new SettingsMenu(configuration);
        settingsMenu.increase();
        settingsMenu.nextEntry();
        settingsMenu.increase();
        settingsMenu.nextEntry();
        settingsMenu.increase();
        Mockito.verify(configuration, Mockito.times(1)).setHeight(16);
        Mockito.verify(configuration, Mockito.times(1)).setWidth(16);
        Mockito.verify(configuration, Mockito.times(1)).setNumMines(16);

        settingsMenu.decrease();
        settingsMenu.previousEntry();
        settingsMenu.decrease();
        settingsMenu.previousEntry();
        settingsMenu.decrease();
        Mockito.verify(configuration, Mockito.times(1)).setHeight(14);
        Mockito.verify(configuration, Mockito.times(1)).setWidth(14);
        Mockito.verify(configuration, Mockito.times(1)).setNumMines(14);
    }
}
