package lpoo.gui;

public class Key {
    GUI.ACTION action;
    Character character;

    public Key(GUI.ACTION action, Character character){
        this.action = action;
        this.character = character;
    }

    public GUI.ACTION getAction() {
        return action;
    }

    public Character getChar() { return character; }
}
