package com.yuan.spring.ioc;

import com.yuan.spring.hello.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanTest {

    //通过id获取bean
    @Test
    public void test_01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) ac.getBean("helloWorld");
        helloWorld.sayHello();
    }

    //通过类型获取bean
    @Test
    public void test_02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld =  ac.getBean(HelloWorld.class); //不用强转
        helloWorld.sayHello();
    }

    //通过id和类型获取bean
    @Test
    public void test_03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = ac.getBean("helloWorld", HelloWorld.class);
        helloWorld.sayHello();
    }

    interface Animal {
        public void sayHi();
    }

    //一定要是静态类,目前不理解原因
    static class Dog implements Animal{
        public Dog() {
        }

        @Override
        public void sayHi() {
            System.out.println("旺旺");
        }
    }

    //接口名获取
    @Test
    public void test_04(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Dog dog1 = (Dog)ac.getBean("dog");
        dog1.sayHi();

        //通过接口，前提是唯一
        Animal dog2 = ac.getBean(Animal.class);
        dog2.sayHi();

        Dog dog3 = ac.getBean(Dog.class);
        dog3.sayHi();
    }
}
