package lpoo.controller.score;

import lpoo.Application;
import lpoo.controller.Controller;
import lpoo.gui.Key;
import lpoo.gui.GUI;
import lpoo.model.score.GameOverMenu;
import lpoo.model.score.HighScoreMenu;
import lpoo.model.menu.Menu;
import lpoo.states.HighScoreState;
import lpoo.states.MenuState;

public class GameOverController extends Controller<GameOverMenu> {
    public GameOverController(GameOverMenu model) {
        super(model);
    }

    @Override
    public void step(Application application, Key key) {
        if(key.getAction() == GUI.ACTION.SELECT){
            if(getModel().isWin() && getModel().isHighScore()){
                application.setState(new HighScoreState(
                        new HighScoreMenu(getModel().getScore(),
                                getModel().getRanking(),
                                getModel().getConfiguration())));
            }
            else application.setState(new MenuState(new Menu(getModel().getConfiguration())));
        }

        if(key.getAction() == GUI.ACTION.QUIT){
            application.setState(null);
        }
    }
}
