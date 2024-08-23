package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    private List<Integer> makeList(){
        List<Integer> list = Arrays.asList(1,2,4,2);
        return list;
    }
    @Test
    public void sort() {
        List<Integer> list = makeList();
        List<Integer> expected = Arrays.asList(1, 2, 2, 4);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
