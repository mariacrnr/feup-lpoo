package lpoo.model.settings;

import lpoo.model.Configuration;
import lpoo.model.Element;

import java.util.Arrays;
import java.util.List;

public class SettingsMenu implements Element {
    private final List<String> entries;
    private int currentEntry = 0;
    private Configuration configuration;
    private List<Field> fields;

    public SettingsMenu(Configuration configuration) {
        this.entries = Arrays.asList("board height", "board width", "number of mines", "back");
        this.configuration = configuration;
        this.fields = Arrays.asList(new HeightField(configuration),
                                    new WidthField(configuration),
                                    new BombField(configuration),
                                    new BackField(configuration));
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedBack() {return isSelected(3);}

    public int getNumberEntries() {
        return this.entries.size();
    }

    public boolean getSelected(int index){
        return isSelected(index);
    }

    public Configuration getConfiguration(){
        return configuration;
    }

    public String getConfigurationValue(int index) {
        String valueStr =  String.valueOf(fields.get(index).getValue());
        if(valueStr.length() == 1) valueStr = " " + valueStr;
        return valueStr;
    }

    public void increase(){
        fields.get(currentEntry).increase();
    }

    public void decrease(){
        fields.get(currentEntry).decrease();
    }
}
