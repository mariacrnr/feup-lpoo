package lpoo.states;

import lpoo.controller.Controller;
import lpoo.controller.score.RankingController;
import lpoo.model.score.RankingMenu;
import lpoo.viewer.View;
import lpoo.viewer.menu.RankingView;


public class RankingState extends State<RankingMenu> {
    public RankingState(RankingMenu ranking) {
        super(ranking);
    }

    @Override
    protected View<RankingMenu> getViewer() {
        return new RankingView(getModel());
    }

    @Override
    protected Controller<RankingMenu> getController() {
        return new RankingController(getModel());
    }
}
