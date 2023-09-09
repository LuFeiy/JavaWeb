package com.yuan.spring.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBean {

    @Test
    public void test_01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Car car1 = context.getBean(Car.class);
        Car car2 = (Car)context.getBean("car");
        Car car3 = context.getBean("car", Car.class);
        car1.sayHi();
        car2.sayHi();
        car3.sayHi();
    }

    @Test
    public void test_02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean(People.class);
        System.out.println(people);
    }

    @Test
    public void test_03(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Spring6Config.class);
        Pet petJerry = (Pet)ac.getBean("petJerry");
        System.out.println(petJerry);
    }

    @Test
    public void test_04(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Spring6Config.class);
        CalculatorImpl calculator = (CalculatorImpl)ac.getBean("CalculatorImpl");
        calculator.add(1, 2);
    }
}
