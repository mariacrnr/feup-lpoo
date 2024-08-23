package lpoo.model.game.tilestate;

public class ClosedState implements TileState {
    @Override
    public TileState flag() {
        return new FlaggedState();
    }

    @Override
    public TileState open() {
        return new OpenState();
    }

    @Override
    public STATE getState() {
        return STATE.CLOSED;
    }
}
