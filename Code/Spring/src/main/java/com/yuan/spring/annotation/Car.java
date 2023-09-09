package com.yuan.spring.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component("car")

public class Car {

    /* 构造方法非必须
    public Car() {
    }
    */
    public void sayHi(){
        System.out.println("Nice to meet you!");
    }
}


