package lpoo.model.menu;

import lpoo.model.Element;

public class Frame implements Element {
    private int width;
    private int height;

    public Frame(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
