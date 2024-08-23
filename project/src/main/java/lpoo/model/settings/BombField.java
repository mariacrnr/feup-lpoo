package lpoo.model.settings;

import lpoo.model.Configuration;

public class BombField extends Field {
    public BombField(Configuration configuration) {
        super(configuration);
    }

    @Override
    public void increase() {
        getConfiguration().setNumMines(getValue() + 1);
    }

    @Override
    public void decrease() {
        getConfiguration().setNumMines(getValue() - 1);
    }

    @Override
    public int getValue() {
        return getConfiguration().getNumMines();
    }
}
