package com.group.libraryapp.dto.HW.response;

public class Day2 {
    private int add;
    private int minus;
    private int multiply;

    public Day2(int add, int minus, int multiply) {
        this.add = add;
        this.minus = minus;
        this.multiply = multiply;
    }

    public int getAdd() {
        return add;
    }
    public int getMinus() {
        return minus;
    }
    public int getMulti() {
        return multiply;
    }

}


