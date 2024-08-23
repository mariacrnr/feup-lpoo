package lpoo.model.game;

import lpoo.model.Element;
import lpoo.model.game.tilestate.ClosedState;
import lpoo.model.game.tilestate.TileState;

public abstract class Tile implements Element {
    protected TileState state;

    Tile(){
        state = new ClosedState();
    }

    public TileState.STATE getStateName(){
        return state.getState();
    }

    public void setState(TileState state){
            this.state = state;
    }

    public TileState getState(){
        return state;
    }

    public abstract int getAdjacentMines();
    public abstract void setAdjacentMines(int adjacentMines);

}
