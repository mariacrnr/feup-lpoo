package lpoo.controller.game.commands;

import lpoo.model.game.Game;

public class FlagCommand implements Command{
    private Game game;

    public FlagCommand(Game game) {
        this.game = game;
    }


    @Override
    public void execute() {
        game.selectedTile().setState(game.selectedTile().getState().flag());
    }

    @Override
    public void undo() {
        game.selectedTile().setState(game.selectedTile().getState().flag());
    }
}
