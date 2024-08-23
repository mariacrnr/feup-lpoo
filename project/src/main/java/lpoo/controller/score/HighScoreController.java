package lpoo.controller.score;

import lpoo.Application;
import lpoo.controller.Controller;
import lpoo.gui.Key;
import lpoo.model.score.HighScoreMenu;
import lpoo.model.menu.Menu;
import lpoo.states.MenuState;

public class HighScoreController extends Controller<HighScoreMenu> {

    public HighScoreController(HighScoreMenu model) {
        super(model);
    }

    @Override
    public void step(Application application, Key key) {
        if(key.getChar() == null){
            switch(key.getAction()){
                case SELECT:
                    if(!getModel().isEmpty()) {
                       getModel().addHighScore();
                       application.setState(new MenuState(new Menu(getModel().getConfiguration())));
                    }
                    break;
                case DELETE:
                    getModel().deleteLastLetter();
                    break;
                case QUIT:
                    application.setState(null);
                    break;
            }
        } else {
            getModel().addChar(key.getChar());
        }

    }

}
