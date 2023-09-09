package com.yuan._1core;

import ch.qos.logback.core.db.DBHelper;
import com.yuan._1core.bean.Dog;
import com.yuan._1core.bean.Pet;
import com.yuan._1core.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;


/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)（保证每个@Bean方法被调用多少次返回的组件都是单实例的）（默认）
 *      Lite(proxyBeanMethods = false)（每个@Bean方法被调用多少次返回的组件都是新创建的）
 */

@Import({Dog.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
class MyConfig {

    @Bean
    public User user01() {
        User zhangsan = new User("zhangsan",19);
        //会提示报错，但是不影响运行
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tom");
    }

}


@TestPropertySource(properties = "notification.service=sms")
public class ConfigurationTest {

    @Test
    public void test_01(){
        //获取ioc容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);

        //查看容器中的组件
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String name: beanNames) {
            System.out.println(name);
        }

        //从容器中获取组件
        Pet tom01 = ac.getBean("tom", Pet.class);
        Pet tom02 = ac.getBean("tom", Pet.class);
        System.out.println("组件: " + (tom01 == tom02));

        //查看MyConfig
        MyConfig bean = ac.getBean(MyConfig.class);
        System.out.println(bean);
    }

    //设置MyConfig类 @Configuration(proxyBeanMethods = true)
    @Test
    public void test_02(){
        //获取ioc容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);

        MyConfig bean = ac.getBean(MyConfig.class);
        System.out.println(bean);

        User user1 = bean.user01();
        User user2 = bean.user01();
        System.out.println(user1 == user2);

        User user3 = ac.getBean("user01", User.class);
        Pet tom = ac.getBean("tom", Pet.class);

        System.out.println("用户的宠物：" + (user3.getPet() == tom));
    }


    //@Import({User.class, DBHelper.class})给容器中**自动创建出这两个类型的组件**、默认组件的名字就是全类名
    @Test
    public void test_03(){
        //获取ioc容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);

        //5、获取组件
        String[] beanNamesForType = ac.getBeanNamesForType(User.class);

        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper dbHelper = ac.getBean(DBHelper.class);
        System.out.println(dbHelper);

    }

    //@Conditional条件装配 之 @ConditionalOnMissingBean
    //1. 大致有三种方式定义bean(xml,注解,配置类(也通过注解))，，然后每种方式有对应的获取ApplicationContext的方式
    //2. 通过注解配置的类必须是public的(测试发现是这样，网上没找到类似的说法)
    @Test
    public void test_04(){
        // 通过启动类来获取容器对象
        //ConfigurableApplicationContext ac = SpringApplication.run(MainApplication.class);
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.scan("com.yuan._1core"); // 扫描包中的组件类
        ac.refresh(); // 刷新容器以加载配置

        //获取组件
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String name: beanNames) {
            System.out.println(name);
        }
    }


    @Test
    public void test_05(){
        // 通过启动类来获取容器对象
        //ConfigurableApplicationContext ac = SpringApplication.run(MainApplication.class);
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.scan("com.yuan._1core"); // 扫描包中的组件类
        ac.refresh(); // 刷新容器以加载配置

        //获取组件
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String name: beanNames) {
            System.out.println(name);
        }
    }
}
