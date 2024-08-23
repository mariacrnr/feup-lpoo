package lpoo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigurationTest {
    @Test
    public void testConfiguration(){
        Configuration configuration = new Configuration(10,10,5);

        configuration.setHeight(23);
        Assertions.assertEquals(configuration.getHeight(),20);

        configuration.setHeight(5);
        Assertions.assertEquals(configuration.getHeight(),6);

        configuration.setWidth(23);
        Assertions.assertEquals(configuration.getWidth(),20);

        configuration.setWidth(5);
        Assertions.assertEquals(configuration.getWidth(),6);

        configuration.setNumMines(40);
        Assertions.assertEquals(configuration.getNumMines(),35);

        configuration.setNumMines(0);
        Assertions.assertEquals(configuration.getNumMines(),1);
    }
}
