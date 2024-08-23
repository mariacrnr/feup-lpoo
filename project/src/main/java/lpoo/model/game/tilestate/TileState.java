package lpoo.model.game.tilestate;

public interface TileState {
    TileState flag();
    TileState open();
    STATE getState();

    enum STATE {FLAGGED, CLOSED, OPEN}
}
