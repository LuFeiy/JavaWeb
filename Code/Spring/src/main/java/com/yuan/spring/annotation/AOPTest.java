package com.yuan.spring.annotation;



import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    @Test
    public void test_01(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Spring6Config.class);
        Calculator calculator = ac.getBean(Calculator.class);
        calculator.add(1, 2);
        System.out.println(calculator);
    }


}
