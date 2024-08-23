package lpoo.viewer;

import lpoo.gui.GUI;
import lpoo.model.menu.Frame;
import lpoo.model.Position;

public class FrameView extends View<Frame> {

    public FrameView(Frame frame) {
        super(frame);
    }

    private void drawVerticalLine(GUI gui, Position position){
        for(int i = 0; i < getModel().getHeight(); i++){
            gui.paintSquare(position.getX(), position.getY()+i,getColor(i));
        }
    }

    private void drawHorizontalLine(GUI gui, Position position){
        for(int i = 0; i < getModel().getWidth(); i++){
            gui.paintSquare(position.getX()+i, position.getY(),getColor(i));
        }
    }

    private void drawFrame(GUI gui, Position pos){
        drawVerticalLine(gui, pos);
        if(getModel().getWidth() != 0)
            drawVerticalLine(gui, new Position(pos.getX() + getModel().getWidth()-1,pos.getY()));
        drawHorizontalLine(gui, pos);
        if(getModel().getHeight() != 0)
            drawHorizontalLine(gui, new Position(pos.getX(), pos.getY()+ getModel().getHeight()-1));
    }

    @Override
    public void drawElement(Position position, GUI gui) {
        drawFrame(gui, position);
    }
}