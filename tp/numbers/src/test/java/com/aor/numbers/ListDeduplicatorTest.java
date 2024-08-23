package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> makeList(){
        List<Integer> list = Arrays.asList(1,2,4,2);
        return list;
    }
    @Test
    public void deduplicate() {
        List<Integer> list = makeList();
        List<Integer> expected = Arrays.asList(1,2,4);

        /*class Stubsorter implements GenericListSort{
            public List<Integer> sort(List<Integer> list){
                List<Integer> result = Arrays.asList(1,2,4);
                return result;
            }
        }*/

        GenericListSort listSorter = Mockito.mock(GenericListSort.class);
        Mockito.when(listSorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));

        ListDeduplicator deduplicator = new ListDeduplicator();
        //Stubsorter listSorter = new Stubsorter();
        List<Integer> distinct = deduplicator.deduplicate(list,listSorter);

        Assertions.assertEquals(expected, distinct);
    }
}
