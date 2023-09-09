package com.yuan.spring.hello;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class HelloWorldTest {

    //创建Logger对象
    private Logger logger = LoggerFactory.getLogger(HelloWorldTest.class);

    @Test
    public void testHelloWorld(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) ac.getBean("helloWorld");
        helloWorld.sayHello();
        //手动写日志
        logger.info("执行成功");
    }
}
