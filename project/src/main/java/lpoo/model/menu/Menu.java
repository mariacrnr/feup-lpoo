package lpoo.model.menu;

import lpoo.model.Configuration;
import lpoo.model.Element;

import java.util.Arrays;
import java.util.List;

public class Menu implements Element {
    private final Configuration configuration;
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu(Configuration configuration) {
        this.entries = Arrays.asList("start game", "settings", "highscores", "controls", "exit");
        this.configuration = configuration;
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

    public boolean isSelectedExit() {
        return isSelected(4);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedSettings() {
        return isSelected(1);
    }

    public boolean isSelectedHighscores() {
        return isSelected(2);
    }

    public boolean isSelectedControls() {
        return isSelected(3);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
