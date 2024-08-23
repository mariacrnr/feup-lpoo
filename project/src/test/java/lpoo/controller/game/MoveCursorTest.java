package lpoo.controller.game;

import lpoo.controller.game.commands.MoveDownCommand;
import lpoo.controller.game.commands.MoveLeftCommand;
import lpoo.controller.game.commands.MoveRightCommand;
import lpoo.controller.game.commands.MoveUpCommand;
import lpoo.model.game.Cursor;
import lpoo.model.game.Game;
import lpoo.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MoveCursorTest {
    private Game game;
    private Cursor cursor;
    private Position position;

    @BeforeEach
    public void moveTestInit(){
        game = Mockito.mock(Game.class);
        cursor = Mockito.mock(Cursor.class);
        position = Mockito.mock(Position.class);
        Mockito.when(game.getCursor()).thenReturn(cursor);
        Mockito.when(cursor.getPosition()).thenReturn(position);
    }

    @Test
    public void moveRightTest(){
        new MoveRightCommand(game).execute();
        Mockito.verify(position, Mockito.times(1)).getRight();
        Mockito.verify(cursor, Mockito.times(1)).setPosition(position.getRight());
    }

    @Test
    public void moveUpTest(){
        new MoveUpCommand(game).execute();
        Mockito.verify(position, Mockito.times(1)).getUp();
        Mockito.verify(cursor, Mockito.times(1)).setPosition(position.getUp());
    }

    @Test
    public void moveLeftTest(){
        new MoveLeftCommand(game).execute();
        Mockito.verify(position, Mockito.times(1)).getLeft();
        Mockito.verify(cursor, Mockito.times(1)).setPosition(position.getLeft());
    }

    @Test
    public void moveDownTest(){
        new MoveDownCommand(game).execute();
        Mockito.verify(position, Mockito.times(1)).getDown();
        Mockito.verify(cursor, Mockito.times(1)).setPosition(position.getDown());
    }

    @Test
    public void moveRightTestUndo(){
        new MoveRightCommand(game).undo();
        Mockito.verify(position, Mockito.times(1)).getLeft();
        Mockito.verify(cursor, Mockito.times(1)).setPosition(position.getLeft());
    }

    @Test
    public void moveUpTestUndo(){
        new MoveUpCommand(game).undo();
        Mockito.verify(position, Mockito.times(1)).getDown();
        Mockito.verify(cursor, Mockito.times(1)).setPosition(position.getDown());
    }

    @Test
    public void moveLeftTestUndo(){
        new MoveLeftCommand(game).undo();
        Mockito.verify(position, Mockito.times(1)).getRight();
        Mockito.verify(cursor, Mockito.times(1)).setPosition(position.getRight());
    }

    @Test
    public void moveDownTestUndo(){
        new MoveDownCommand(game).undo();
        Mockito.verify(position, Mockito.times(1)).getUp();
        Mockito.verify(cursor, Mockito.times(1)).setPosition(position.getUp());
    }

}
