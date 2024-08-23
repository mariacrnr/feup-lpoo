package lpoo.model.menu;

import lpoo.model.Configuration;
import lpoo.model.Element;

import java.util.Arrays;
import java.util.List;

public class ControlsMenu implements Element {
    private final Configuration configuration;
    private static List<String> controls;
    private static List<String> description;

    public ControlsMenu(Configuration configuration){
        this.configuration = configuration;
        controls = Arrays.asList("A", "S", "Z", "esc","arrows", "enter");
        description = Arrays.asList("select tile", "flag & unflag", "undo move", "back to menu", "move cursor", "menu select");
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public List<String> getControls() {
        return controls;
    }

    public List<String> getDescription(){
        return description;
    }
}
