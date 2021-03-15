package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private Integer number;
    public DivisibleByFilter(int number){
        if(number == 0) this.number = 1;
        else this.number = number;
    }
    public boolean accept(Integer number){
        return number % this.number == 0;
    }
}
