package lpoo.controller.game.commands;

import lpoo.model.game.Game;

public class MoveUpCommand extends CursorMoveCommand {
    public MoveUpCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getCursor().setPosition(getCursor().getPosition().getUp());
    }

    @Override
    public void undo() {
        getCursor().setPosition(getCursor().getPosition().getDown());
    }
}
