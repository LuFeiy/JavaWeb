package com.yuan.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    @Test
    public void test_01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Calculator calculator = ac.getBean(Calculator.class);
        int result = calculator.add(1, 1);
        System.out.println("执行成功result：" + result);
    }
}
