package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    List<Integer> list;
    public ListFilterer(List<Integer> list){
        this.list = list;
    }
    public List<Integer> filter(GenericListFilter filterer){
        List<Integer> result = new ArrayList<>();
        for(int num: this.list)
            if(filterer.accept(num)) result.add(num);

        return result;

    }
}

