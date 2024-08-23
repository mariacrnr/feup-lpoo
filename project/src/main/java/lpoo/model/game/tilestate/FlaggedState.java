package lpoo.model.game.tilestate;

public class FlaggedState implements TileState {

    @Override
    public TileState flag() {
        return new ClosedState();
    }

    @Override
    public TileState open() {
        return new FlaggedState();
    }

    @Override
    public STATE getState() {
        return STATE.FLAGGED;
    }
}
