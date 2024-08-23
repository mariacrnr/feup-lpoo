package lpoo.model.settings;

import lpoo.model.Configuration;

public abstract class Field {
    private Configuration configuration;

    public Field(Configuration configuration){
        this.configuration = configuration;
    }

    public abstract void increase();

    public abstract void decrease();

    public abstract int getValue();

    protected Configuration getConfiguration(){
        return configuration;
    }
}
