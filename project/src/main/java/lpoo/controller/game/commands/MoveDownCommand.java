package lpoo.controller.game.commands;

import lpoo.model.game.Game;

public class MoveDownCommand extends CursorMoveCommand {
    public MoveDownCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getCursor().setPosition(getCursor().getPosition().getDown());
    }

    @Override
    public void undo() {
        getCursor().setPosition(getCursor().getPosition().getUp());
    }
}
