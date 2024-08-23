package lpoo.controller.game.commands;

import lpoo.model.game.Game;

public class MoveRightCommand extends CursorMoveCommand {
    public MoveRightCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        getCursor().setPosition(getCursor().getPosition().getRight());
    }

    @Override
    public void undo() {
        getCursor().setPosition(getCursor().getPosition().getLeft());
    }
}
