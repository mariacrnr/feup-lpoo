import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBarTest {
    @Test
    public void happyHour() {
        Bar bar = new StringBar();
        assertFalse(bar.isHappyHour());

        bar.startHappyHour();
        assertTrue(bar.isHappyHour());

        bar.endHappyHour();
        assertFalse(bar.isHappyHour());
    }
}