package lpoo.model.settings;

import lpoo.model.Configuration;

public class WidthField extends Field {
    public WidthField(Configuration configuration) {
        super(configuration);
    }

    @Override
    public void increase() {
        getConfiguration().setWidth(getValue() + 1);
    }

    @Override
    public void decrease() {
        getConfiguration().setWidth(getValue() - 1);
    }

    @Override
    public int getValue() {
        return getConfiguration().getWidth();
    }
}
