package lpoo.controller.game.commands;

import lpoo.model.game.Board;
import lpoo.model.game.Game;
import lpoo.model.Position;
import lpoo.model.game.Tile;
import lpoo.model.game.tilestate.ClosedState;
import lpoo.model.game.tilestate.TileState;

import java.util.ArrayList;
import java.util.List;

public class OpenCommand implements Command{
    private Game game;
    private List<Tile> openedTiles;

    public OpenCommand(Game game) {
        this.game = game;
        this.openedTiles = new ArrayList<>();
    }

    private Position getCursorPosition(){
        return game.getCursor().getPosition();
    }

    private Board getGameBoard(){
        return game.getBoard();
    }

    private Tile getTileAtPosition(int x, int y){
        return getGameBoard().getTileAtPosition(new Position(x,y));
    }

    private void cascadeOpen(int x, int y){
        if(getTileAtPosition(x,y).getStateName() == TileState.STATE.CLOSED){
            openedTiles.add(getTileAtPosition(x,y));
            getTileAtPosition(x,y).setState(getTileAtPosition(x,y).getState().open());
            if(getTileAtPosition(x,y).getAdjacentMines() == 0) openAdjacent(x,y);
        }
    }

    private void openAdjacent(int x, int y){
        for(int line = Math.max(0, x - 1); line < Math.min(getGameBoard().getHeight(), x + 2); line++){
            for(int col = Math.max(0, y - 1); col < Math.min(getGameBoard().getWidth(), y + 2); col++){
                if(line == x && col == y) continue;
                cascadeOpen(line,col);
            }
        }
    }

    @Override
    public void execute(){
        cascadeOpen(getCursorPosition().getX(), getCursorPosition().getY());

        int remainingTiles = getGameBoard().getRemainingTiles() - openedTiles.size();
        getGameBoard().setRemainingTiles(remainingTiles);
    }

    @Override
    public void undo(){
        for(Tile tile : openedTiles){
            tile.setState(new ClosedState());
        }
        getGameBoard().setRemainingTiles(getGameBoard().getRemainingTiles() + openedTiles.size());
    }
}
