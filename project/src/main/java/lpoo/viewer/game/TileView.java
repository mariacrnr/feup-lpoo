package lpoo.viewer.game;

import lpoo.gui.GUI;
import lpoo.model.Position;
import lpoo.model.game.Tile;
import lpoo.viewer.View;

public class TileView extends View<Tile> {

    public TileView(Tile tile) {
        super(tile);
    }

    @Override
    protected void drawElement(Position position, GUI gui) {
        Tile tile = getModel();
        switch(tile.getStateName()){
            case OPEN:
                String adjacentMinesString = String.valueOf(tile.getAdjacentMines());
                if(!adjacentMinesString.equals("-1"))
                    gui.drawString(adjacentMinesString,
                            position.getX(),
                            position.getY(),
                            getColorsList().get(tile.getAdjacentMines()));
                break;
            case FLAGGED:
                gui.drawString("!", position.getX(), position.getY(), "#FFF200");
                break;
            case CLOSED:
                gui.drawString("-", position.getX(), position.getY(), "#FFFFFF");
                break;
            default:
                break;
        }
    }
}
