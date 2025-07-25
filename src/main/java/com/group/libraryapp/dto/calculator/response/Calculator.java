package com.group.libraryapp.dto.calculator.response;

public class Calculator {
    private int add;
    private int minus;
    private int multiply;

    public Calculator(int add, int minus, int multiply) {
        this.add = add;
        this.minus = minus;
        this.multiply = multiply;
    }

    public int getAddition() {
        return add;
    }
    public int getMinus() {
        return minus;
    }
    public int getMulti() {
        return multiply;
    }

}
