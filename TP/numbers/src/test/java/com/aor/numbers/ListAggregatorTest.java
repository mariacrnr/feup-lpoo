package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void min() {
        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class Stubdeduplicator implements GenericListDeduplicator{
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
        }

        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        Stubdeduplicator deduplicator = new Stubdeduplicator();
        Stubsorter listSorter = new Stubsorter();
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
        class Stubdeduplicator implements GenericListDeduplicator{
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
        }

        List<Integer> list = makeList();

        ListAggregator aggregator = new ListAggregator();
        Stubdeduplicator deduplicator = new Stubdeduplicator();
        Stubsorter listSorter = new Stubsorter();
        int distinct = aggregator.distinct(list, deduplicator, listSorter);

        Assertions.assertEquals(3, distinct);
    }
}
