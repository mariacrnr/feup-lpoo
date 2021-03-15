package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


class ListFiltererTest {
    private List<Integer> makeList(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        return list;
    }
    @Test
    public void filter(){
        List<Integer> list = makeList();
        List<Integer> expected = Arrays.asList();
        List<Integer> expected1 = Arrays.asList(1,2,3,4);
        List<Integer> expected2 = Arrays.asList(2,4);


        GenericListFilter listFilterer = Mockito.mock(GenericListFilter.class);
        Mockito.when(listFilterer.accept(Mockito.anyInt())).thenReturn(false);

        ListFilterer filterer = new ListFilterer(list);
        List<Integer> filtered = filterer.filter(listFilterer);

        Assertions.assertEquals(expected, filtered);


        Mockito.when(listFilterer.accept(Mockito.anyInt())).thenReturn(true);
        List<Integer> filtered1 = filterer.filter(listFilterer);

        Assertions.assertEquals(expected1, filtered1);


        Mockito.when(listFilterer.accept(Mockito.anyInt())).thenAnswer(I -> (int)(I.getArgument(0)) % 2 == 0);

        List<Integer> filtered2 = filterer.filter(listFilterer);

        Assertions.assertEquals(expected2, filtered2);
    }
}