package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> makeList(){
        List<Integer> list = Arrays.asList(1,2,4,2);
        return list;
    }
    @Test
    public void sum() {
        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(9, sum);
    }

    @Test
    public void max() {
        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(4, max);

        max = aggregator.max(Arrays.asList(1,2,2));

        Assertions.assertEquals(2, max);
    }

    @Test
    public void min() {
        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);

        min = aggregator.min(Arrays.asList(-1,-1,4));

        Assertions.assertEquals(-1,min);
    }

    @Test
    public void distinct() {
        /*class Stubdeduplicator implements GenericListDeduplicator{
            public List<Integer> deduplicate(List<Integer> list, GenericListSort listSorter){
                List<Integer> result = Arrays.asList(1,2,4);
                return result;
            }
        }
        class Stubsorter implements GenericListSort{
            public List<Integer> sort(List<Integer> list){
                List<Integer> result = Arrays.asList(1,2,4);
                return result;
            }
        }*/

        GenericListSort listSorter = Mockito.mock(GenericListSort.class);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList(),Mockito.any())).thenReturn(Arrays.asList(1, 2, 4));


        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        /*Stubdeduplicator deduplicator = new Stubdeduplicator();
        Stubsorter listSorter = new Stubsorter();*/
        int distinct = aggregator.distinct(list, deduplicator, listSorter);

        Assertions.assertEquals(3, distinct);
    }

    @Test
    public void max_bug_7263(){
        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(4, max);
    }

    @Test
    public void distinct_bug_8726(){
        /*class Stubdeduplicator implements GenericListDeduplicator{
            public List<Integer> deduplicate(List<Integer> list, GenericListSort listSorter){
                List<Integer> result = Arrays.asList(1,2,4);
                return result;
            }
        }
        class Stubsorter implements GenericListSort{
            public List<Integer> sort(List<Integer> list){
                List<Integer> result = Arrays.asList(1,2,4);
                return result;
            }
        }*/

        GenericListSort listSorter = Mockito.mock(GenericListSort.class);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList(),Mockito.any())).thenReturn(Arrays.asList(1, 2, 4));
        Mockito.when(listSorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));

        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        /*Stubdeduplicator deduplicator = new Stubdeduplicator();
        Stubsorter listSorter = new Stubsorter();*/
        int distinct = aggregator.distinct(list, deduplicator, listSorter);

        Assertions.assertEquals(3, distinct);
    }
}
