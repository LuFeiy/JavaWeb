package _4advanced.reflect;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static _4advanced.reflect.ClassDemo.print;
class Candy {static {print("Loading Candy");}}
class Gum {static {print("Gum Candy");}}
class Cookie {static {print("Cookie Candy");}}

class MyClass implements MyInterface {
    public int value;
    public String name;

    public MyClass() {
    }

    public MyClass(int value) {
        this.value = value;
    }

    public void method() {
    }

    public String toString() {
        return "MyClass";
    }
}

interface MyInterface {
    void method();
}

public class ClassDemo {

    public static void print(Object o){System.out.println(o);}

    @Test
    public void test_01() {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("_4advanced.reflect.Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }

    @Test
    public void test_02() throws InstantiationException, IllegalAccessException {
        Class myClass = MyClass.class;

        //获取类的名称
        String className = myClass.getName();
        System.out.println("Class name:" + className);

        //获取类的简单名称
        String simpleName = myClass.getSimpleName();
        System.out.println("Simple name:" + myClass.getSimpleName());

        // 获取类的修饰符
        int modifiers = myClass.getModifiers();
        System.out.println("modifiers: " + modifiers);

        //获取类的包信息
        Package classPackage = myClass.getPackage();
        System.out.println("classPackage: " + classPackage);

        //获取类的父类
        Class superclass = myClass.getSuperclass();
        System.out.println("superclass: " + superclass);

        //获取实现的接口
        Class[] interfaces = myClass.getInterfaces();
        for (Class iface:interfaces) {
            System.out.println("Interfaces: " + iface);
        }

        //获取类的公共构造函数
        Constructor[] constructors = myClass.getConstructors();
        for (Constructor constructor :constructors) {
            System.out.println("Constructor:" + constructor);
        }

        //获取类的公共字段
        Field[] fields = myClass.getFields();
        for (Field field :fields) {
            System.out.println("Field:" +field.getName());
        }

        //实例化
        Object mc = (MyClass)myClass.newInstance();
        System.out.println(mc);

    }
}
