package _4advanced.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenericDemo {




    //1. 简单泛型的使用
    @Test
    public void test_01(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        //list.add(123); 在编译阶段会报错：Required type: String
        String string = list.get(0); //取出的时候不用做强制类型转换
    }

    //2.泛型类
    class Point<T>{
        private T t;

        public Point(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

    }
    //多个泛型参数也是可以的
    class Point2<K,V>{

    }

    @Test
    public void test_02(){
        Point p1 = new Point("StringField");
        Point p2 = new Point(1234d);

        System.out.println(p1.getT());
        System.out.println(p2.getT());
    }


    //3. 泛型接口
    interface Info<T>{
        public void setVar(T t);
        public T getVar();
    }

    //实现类带入泛型类型
    class InfoImpl1 implements Info<String>{

        private String name;
        @Override
        public void setVar(String s) {
            this.name = s;
        }

        @Override
        public String getVar() {
            return name;
        }
    }

    //实现类也可以不带入实际类型，那么实际的类型就为退为raw type: Object
    class InfoImpl2 implements Info{

        private Object o;
        @Override
        public void setVar(Object o) {
            this.o = o;
        }

        @Override
        public Object getVar() {
            return o;
        }
    }

    @Test
    public void test_03(){
        InfoImpl1 infoImpl1 = new InfoImpl1();
        infoImpl1.setVar("I am InfoImpl1");
        System.out.println(infoImpl1.getVar());


    }


    // 4. 泛型方法
    public static <K> K getFirstElement(K[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }

    public class MyClass {
        // 类定义
    }

    @Test
    public void test_04(){
        System.out.println(String.class);
        System.out.println(MyClass.class);
        System.out.println(MyClass.class.getClass());

        //Class就是一个泛型类
        Class<MyClass> myClassClass = MyClass.class;

        //使用泛型方法
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"apple", "banana", "cherry"};

        Integer firstInt = getFirstElement(intArray);
        String firstString = getFirstElement(stringArray);

        System.out.println("First element of integer array: " + firstInt);
        System.out.println("First element of string array: " + firstString);

    }


    // 测试只有返回值包含泛型的泛型方法,语法上存在这种用法，但实际上有没有什么用还待了解发现
    public static <X> X getCharSequence() {
        return (X) "hello";
    }

    @Test
    public void test_05(){
        String str = getCharSequence();
        System.out.println("str: " + str);
    }


}
