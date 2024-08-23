package lpoo.viewer;

import lpoo.gui.GUI;
import lpoo.model.Element;
import lpoo.model.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class View<T extends Element>{
    private final T model;
    protected static final int TITLE_ROW = 3;

    private static final List<String> colors = new ArrayList<String>() {
        {
            add("#05122D");
            add("#CC99C9");
            add("#9EC1CF");
            add("#9BE564");
            add("#FDFD97");
            add("#FEB144");
            add("#FF6663");
            add("#EB6424");
            add("#FFFFFF");
        }
    };

    public View(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(Position position, GUI gui) throws IOException {
        gui.clear();
        drawElement(position,gui);
        gui.refresh();
    }

    public String getColor(int index){
        int colorIndex = (index % colors.size() == 0) ? 2 : index % colors.size();
        return colors.get(colorIndex);
    }

    public int drawMultiColoredTitle(GUI gui, String text, int row){
        int center = gui.getWidthPos(text.length());
        for(int i = 0; i < text.length(); i++){
            String str = Character.toString(text.charAt(i));
            gui.drawString(str,center+i,row,getColor(i));
        }
        return center;
    }

    public  List<String> getColorsList(){
        return colors;
    }

    protected abstract void drawElement(Position position, GUI gui);
}
