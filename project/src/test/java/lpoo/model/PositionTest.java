package lpoo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void testDirections(){
        Position position = new Position(3,4);
        Position left = position.getLeft();
        Position right = position.getRight();
        Position down = position.getDown();
        Position up = position.getUp();

        Assertions.assertEquals(left.getX(),3);
        Assertions.assertEquals(left.getY(),3);

        Assertions.assertEquals(right.getX(),3);
        Assertions.assertEquals(right.getY(),5);

        Assertions.assertEquals(up.getX(),2);
        Assertions.assertEquals(up.getY(),4);

        Assertions.assertEquals(down.getX(),4);
        Assertions.assertEquals(down.getY(),4);
    }
}
