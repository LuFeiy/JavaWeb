package _4advanced.reflect;


import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;

@Data
class Person{
    public int age;
    public String name;
    //省略set和get方法
}

class Student extends Person{
    public String desc;
    private int score;
    //省略set和get方法
}

public class FieldTest {

    @Test
    public void test_01() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazz = Class.forName("_4advanced.reflect.Student");
        // 获取指定字段名称的Field类,注意字段秀是否为public,且要存在,
        // 不然报错NoSuchFiledException
        Field field = clazz.getField("age");
        System.out.println("field:"+field);

        //获取所有修饰符为public的字段,包括父类的字段,要求也是public
        Field[] fields = clazz.getFields();
        for (Field f :fields) {
            System.out.println("f:"+f.getDeclaringClass());
        }

        System.out.println("-------------getDeclaredFields--------------");
        //获取当前类所有字段,包括private,不包括父类字段
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field f :fields2) {
            System.out.println("f:"+f.getDeclaringClass());
        }

        //获取指定字段(任意修饰符,不包括自身字段)
        Field field2 = clazz.getDeclaredField("desc");
        System.out.println("fields2:"+field2);

    }


    @Test
    public void test_02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = Class.forName("_4advanced.reflect.Student");
        Student st = (Student)clazz.newInstance();
        //获取父类public字段并赋值
        Field ageField = clazz.getField("age");
        ageField.set(st,18);
        System.out.println(st);
        Field nameField = clazz.getField("name");
        nameField.set(st,"yuan");
        System.out.println(st);
    }
}
