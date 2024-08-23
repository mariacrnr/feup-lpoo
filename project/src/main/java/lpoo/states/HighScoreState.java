package lpoo.states;

import lpoo.controller.Controller;
import lpoo.controller.score.HighScoreController;
import lpoo.model.score.HighScoreMenu;
import lpoo.viewer.View;
import lpoo.viewer.menu.HighScoreMenuView;

public class HighScoreState extends State<HighScoreMenu> {
    public HighScoreState(HighScoreMenu model) {
        super(model);
    }

    @Override
    protected View<HighScoreMenu> getViewer() {
        return new HighScoreMenuView(getModel());
    }

    @Override
    protected Controller<HighScoreMenu> getController() {
        return new HighScoreController(getModel());
    }

}
