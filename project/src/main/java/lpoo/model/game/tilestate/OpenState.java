package lpoo.model.game.tilestate;

public class OpenState implements TileState {
    @Override
    public TileState flag() {
        return new OpenState();
    }

    @Override
    public TileState open() {
        return new OpenState();
    }

    @Override
    public STATE getState() {
        return STATE.OPEN;
    }
}
