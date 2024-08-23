package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveFilterTest {
    @Test
    public void accept(){
        PositiveFilter pos = new PositiveFilter();

        Assertions.assertEquals(true, pos.accept(6));
        Assertions.assertEquals(false, pos.accept(-1));
        Assertions.assertEquals(false, pos.accept(-10));
        Assertions.assertEquals(true, pos.accept(3));
        Assertions.assertEquals(false, pos.accept(0));
    }
}