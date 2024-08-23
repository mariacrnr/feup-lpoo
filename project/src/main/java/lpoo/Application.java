package lpoo;

import lpoo.gui.GUI;
import lpoo.gui.LanternaGUI;
import lpoo.model.Configuration;
import lpoo.model.menu.Menu;
import lpoo.states.*;

import java.io.IOException;

public class Application {
    private GUI gui;
    private State state;

    public Application() {
        this.gui = new LanternaGUI(LanternaGUI.DEFAULT_COLS, LanternaGUI.DEFAULT_ROWS);
        this.state = new MenuState(new Menu(new Configuration(10,10,5)));
    }

    public void setState(State state)  {
            this.state = state;
    }

    public void changeGUI(GUI gui){
        try {
            this.gui.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.gui = gui;
    }

    public void setDefaultGUI(){
        try {
            this.gui.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.gui = new LanternaGUI(LanternaGUI.DEFAULT_COLS, LanternaGUI.DEFAULT_ROWS);
    }

    public static void main(String[] args) throws IOException {
        new Application().start();
    }

    private void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}
