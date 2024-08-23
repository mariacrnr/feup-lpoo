package lpoo.model.menu;

import lpoo.model.Configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {
    private Configuration configuration;
    private Menu menu;
    @BeforeEach
    public void MenuInit(){
        menu = new Menu(configuration);
    }

    @Test
    public void MenuPreviousEntry(){
        menu.previousEntry();
        Assertions.assertTrue(menu.isSelected(menu.getNumberEntries() - 1));
    }

    @Test
    public void MenuNextEntry(){
        for (int i = 0; i < menu.getNumberEntries(); i++)
            menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(0));
    }
}
