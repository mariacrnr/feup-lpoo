package lpoo.states;

import lpoo.controller.Controller;
import lpoo.controller.score.GameOverController;
import lpoo.model.score.GameOverMenu;
import lpoo.viewer.View;
import lpoo.viewer.menu.GameOverView;

public class GameOverState extends State<GameOverMenu>{
    public GameOverState(GameOverMenu model) {
        super(model);
    }

    @Override
    protected View<GameOverMenu> getViewer() {
        return new GameOverView(getModel());
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverController(getModel());
    }
}
