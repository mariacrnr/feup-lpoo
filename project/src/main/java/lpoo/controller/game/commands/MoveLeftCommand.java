package lpoo.controller.game.commands;

import lpoo.model.game.Game;

public class MoveLeftCommand extends CursorMoveCommand {
    public MoveLeftCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getCursor().setPosition(getCursor().getPosition().getLeft());
    }

    @Override
    public void undo() {
        getCursor().setPosition(getCursor().getPosition().getRight());
    }
}
