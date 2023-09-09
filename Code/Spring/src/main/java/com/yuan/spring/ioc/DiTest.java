package com.yuan.spring.ioc;


import lombok.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
class Student{
    private Integer id;
    private String name;
    private String age;
    private String sex;
    private Clazz clazz;
    private String[] hobbies;

    public Student(Integer id, String name, String age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Student(Integer id, String name, String age, String sex, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.clazz = clazz;
    }
}

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Clazz {
    private Integer clazzId;
    private String clazzName;
    private List<Student> students;
}

public class DiTest {

    //set注入
    @Test
    public void test_01(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student studentOne = ac.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void test_02(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student studentOne = ac.getBean("studentTwo", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void test_03(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student studentOne = ac.getBean("studentThree", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void test_04(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student studentOne = ac.getBean("studentFour", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void test_05(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student studentOne = ac.getBean("studentFive", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void test_06(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student studentOne = ac.getBean("studentSix", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void test_07(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student studentOne = ac.getBean("studentSeven", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void test_08(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Clazz clazz = ac.getBean("clazzTwo", Clazz.class);
        System.out.println(clazz);
    }

    @Test
    public void test_09(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student student = ac.getBean("studentNine", Student.class);
        System.out.println(student);
    }

    @Test
    public void test_10() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DataSource dataSource = ac.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }




}
