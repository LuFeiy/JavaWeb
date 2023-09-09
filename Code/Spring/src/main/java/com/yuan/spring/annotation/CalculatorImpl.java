package com.yuan.spring.annotation;

import org.springframework.stereotype.Component;

interface Calculator{
    int add(int i, int j);

    int sub(int i, int j);
}

@Component
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
