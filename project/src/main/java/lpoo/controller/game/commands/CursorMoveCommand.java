package lpoo.controller.game.commands;

import lpoo.model.game.Cursor;
import lpoo.model.game.Game;

public abstract class CursorMoveCommand implements Command{
    private Game game;

    public CursorMoveCommand(Game game){
        this.game = game;
    }

    protected Cursor getCursor(){
        return game.getCursor();
    }

    @Override
    public abstract void execute();

    @Override
    public abstract void undo();
}
