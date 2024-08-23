package lpoo.controller;

import lpoo.Application;
import lpoo.gui.Key;
import lpoo.model.Element;

public abstract class Controller<T extends Element> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Application application, Key key);
}
