package com.yuan.spring.aop;

interface Calculator{
    int add(int i, int j);

    int sub(int i, int j);
}

public class CalculatorImpl implements Calculator {
    public int add(int i, int j) {

        int result = i + j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    public int sub(int i, int j) {

        int result = i - j;

        System.out.println("方法内部 result = " + result);

        return result;
    }
}
