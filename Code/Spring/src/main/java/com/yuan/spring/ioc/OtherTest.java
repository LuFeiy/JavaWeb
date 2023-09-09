package com.yuan.spring.ioc;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* 具体的生命周期过程
- bean对象创建（调用无参构造器）

- 给bean对象设置属性

- bean的后置处理器（初始化之前）

- bean对象初始化（需在配置bean时指定初始化方法）

- bean的后置处理器（初始化之后）

- bean对象就绪可以使用

- bean对象销毁（需在配置bean时指定销毁方法）

- IOC容器关闭
*
* */

@Data
class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;

}

@Data
class Cat {
    private String name;

    public Cat() {
        System.out.println("生命周期：1、创建对象");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("生命周期：2、依赖注入");
    }

    public void initMethod(){
        System.out.println("生命周期：3、初始化");
    }

    public void destroyMethod(){
        System.out.println("生命周期：5、销毁");
    }
}

class Mybeanprocessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("☆☆☆" + beanName + " = " + bean);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("☆☆☆" + beanName + " = " + bean);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}

class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}

public class OtherTest {
    @Test
    public void test_01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = ac.getBean("suser", User.class);
        User user2 = ac.getBean("suser", User.class);
        User user3 = ac.getBean("puser", User.class);
        User user4 = ac.getBean("puser", User.class);
        System.out.println(user1==user2);
        System.out.println(user3==user4);
    }

    @Test
    public void test_02(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Cat cat = ac.getBean(Cat.class);
        System.out.println(cat);
        ac.close();
    }

    @Test
    public void test_03(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Cat cat = ac.getBean(Cat.class);
        System.out.println(cat);
        ac.close();
    }

    @Test
    public void test_04(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }
}
