package lpoo.states;

import lpoo.controller.Controller;
import lpoo.controller.game.GameController;
import lpoo.model.game.Game;
import lpoo.viewer.game.GameView;
import lpoo.viewer.View;

public class GameState extends State<Game> {
    public GameState(Game game){
        super(game);
    }
    @Override
    protected View<Game> getViewer() {
        return new GameView(getModel());
    }

    @Override
    protected Controller<Game> getController() {
        return new GameController(getModel());
    }
}
