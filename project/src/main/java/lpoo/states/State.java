package lpoo.states;

import lpoo.Application;
import lpoo.controller.Controller;
import lpoo.gui.Key;
import lpoo.gui.GUI;
import lpoo.model.Element;
import lpoo.model.Position;
import lpoo.viewer.View;

import java.io.IOException;

public abstract class State<T extends Element> {
    private final T model;
    private final Controller<T> controller;
    private final View<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract View<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Application application, GUI gui) throws IOException {
        Key key = gui.getNextKey();
        controller.step(application,  key);
        viewer.draw(new Position(0,0),gui);
    }
}