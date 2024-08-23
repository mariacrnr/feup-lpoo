package lpoo.model.menu;

import lpoo.model.Configuration;

import lpoo.model.settings.SettingsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;


public class SettingsMenuTest {
    private Configuration configuration;
    private SettingsMenu menu;

    @BeforeEach
    void settingsMenuInit(){
        configuration = Mockito.mock(Configuration.class);
        menu = new SettingsMenu(configuration);
        Mockito.when(configuration.getHeight()).thenReturn(15);
        Mockito.when(configuration.getWidth()).thenReturn(12);
        Mockito.when(configuration.getNumMines()).thenReturn(6);
    }
    @Test
    void settingsMenuIncrease(){
        menu.increase();
        Mockito.verify(configuration, Mockito.times(1)).setHeight(16);

        menu.nextEntry();
        menu.increase();

        Mockito.verify(configuration, Mockito.times(1)).setWidth(13);

        menu.nextEntry();
        menu.increase();

        Mockito.verify(configuration, Mockito.times(1)).setNumMines(7);

    }
    @Test
    void settingsMenuDecrease(){
        menu.decrease();
        Mockito.verify(configuration, Mockito.times(1)).setHeight(14);

        menu.nextEntry();
        menu.decrease();

        Mockito.verify(configuration, Mockito.times(1)).setWidth(11);

        menu.nextEntry();
        menu.decrease();

        Mockito.verify(configuration, Mockito.times(1)).setNumMines(5);
    }


}
