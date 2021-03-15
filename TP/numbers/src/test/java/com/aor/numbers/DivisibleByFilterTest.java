package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DivisibleByFilterTest {

    @Test
    public void accept(){
        DivisibleByFilter div = new DivisibleByFilter(2);

        Assertions.assertEquals(true, div.accept(6));
        Assertions.assertEquals(false, div.accept(-1));
        Assertions.assertEquals(true, div.accept(-10));
        Assertions.assertEquals(false, div.accept(3));
    }

}