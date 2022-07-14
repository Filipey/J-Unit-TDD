package com.filipey.models;

public class Calculator {

    public int sum(int num, int num2) {

        if (num < 0 || num2 < 0) {
            throw new RuntimeException("Cant sum negative numbers");
        }

        return num + num2;
    }

    public int sub(int num, int num2) {
        return num - num2;
    }

    public int mult(int num, int num2) {
        return num * num2;
    }

    public float div(float num, float num2) {

        if (num2 <= 0) {
            throw new ArithmeticException("Cant divide by 0");
        }

        return num/num2;
    }
}
