package lpoo.model.settings;

import lpoo.model.Configuration;

public class HeightField extends Field {
    public HeightField(Configuration configuration) {
        super(configuration);
    }

    @Override
    public void increase() {
        getConfiguration().setHeight(getValue() + 1);
    }

    @Override
    public void decrease() {
        getConfiguration().setHeight(getValue() - 1);
    }

    @Override
    public int getValue() {
        return getConfiguration().getHeight();
    }
}
