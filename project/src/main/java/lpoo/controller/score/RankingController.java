package lpoo.controller.score;

import lpoo.Application;
import lpoo.controller.Controller;
import lpoo.gui.Key;
import lpoo.gui.GUI;
import lpoo.model.menu.Menu;
import lpoo.model.score.RankingMenu;
import lpoo.states.MenuState;

public class RankingController extends Controller<RankingMenu> {
    public RankingController(RankingMenu ranking) {
        super(ranking);
    }

    @Override
    public void step(Application application, Key action) {
        if(action.getAction() == GUI.ACTION.SELECT){
            application.setState(new MenuState(new Menu(getModel().getConfiguration())));
        }
    }
}
