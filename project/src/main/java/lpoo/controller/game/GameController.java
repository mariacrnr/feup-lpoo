package lpoo.controller.game;

import lpoo.Application;
import lpoo.controller.Controller;
import lpoo.controller.game.commands.*;
import lpoo.gui.Key;
import lpoo.model.game.Game;
import lpoo.model.game.Tile;
import lpoo.model.game.tilestate.TileState;
import lpoo.model.score.GameOverMenu;
import lpoo.model.menu.Menu;
import lpoo.states.GameOverState;
import lpoo.states.MenuState;

import java.util.Stack;

public class GameController extends Controller<Game> {
    private final Stack<Command> commands;
    private Command command = null;

    public GameController(Game game){
        super(game);
        this.commands = new Stack<>();
    }

    protected void executeCommand(Command command) {
        commands.push(command);
        command.execute();
    }

    private void undoLastCommand(){
        if(!commands.empty()){
            commands.peek().undo();
            commands.pop();
        }
    }

    private void checkGameOver(Application application) {
        if(getModel().getBoard().getRemainingTiles() == 0) {
            application.setState(new GameOverState(new GameOverMenu(getModel().getConfiguration(), true, getModel().getScore())));
            application.setDefaultGUI();
        }

        Tile changedTile = getModel().selectedTile();
        if(changedTile.getAdjacentMines() == -1 && changedTile.getStateName() == TileState.STATE.OPEN){
            application.setState(new GameOverState(new GameOverMenu(getModel().getConfiguration(), false, getModel().getScore())));
            application.setDefaultGUI();
        }
    }

    @Override
    public void step(Application application, Key key) {
        switch (key.getAction()){
            case UP:
                executeCommand(new MoveUpCommand(getModel()));
                break;
            case DOWN:
                executeCommand(new MoveDownCommand(getModel()));
                break;
            case LEFT:
                executeCommand(new MoveLeftCommand(getModel()));
                break;
            case RIGHT:
                executeCommand(new MoveRightCommand(getModel()));
                break;
            case FLAG:
                executeCommand(new FlagCommand(getModel()));
                break;
            case OPEN:
                executeCommand(new OpenCommand(getModel()));
                break;
            case BACK:
                undoLastCommand();
                break;
            case QUIT:
                application.setState(null);
                break;
            case ESCAPE:
                application.setState(new MenuState(new Menu(getModel().getConfiguration())));
                application.setDefaultGUI();
        }

        checkGameOver(application);
    }


}
