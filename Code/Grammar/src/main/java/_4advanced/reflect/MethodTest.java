package _4advanced.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Shape {
    public void draw(){
        System.out.println("draw");
    }

    public void draw(int count , String name){
        System.out.println("draw "+ name +",count="+count);
    }

}
class Circle extends Shape{

    private void drawCircle(){
        System.out.println("drawCircle");
    }
    public int getAllCount(){
        return 100;
    }
}

public class MethodTest {

    @Test
    public void test_01() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("_4advanced.reflect.Circle");

        //更具参数获取public的Method,包含继承自父类的方法
        Method method = clazz.getMethod("draw", int.class, String.class);
        System.out.println("method:" + method);

        //获取所有public 方法
        Method[] methods = clazz.getMethods();
        for (Method m :methods) {
            System.out.println("m:"+ m);
        }

        System.out.println("----------------------");

        //获取当前类的特定方法包含private,无法获取继承自父类的method
        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method1:"+method1);

        //获取当前类的所有方法包含private,无法获取继承自父类的method
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m :declaredMethods) {
            System.out.println("m1:"+m);
        }

    }


    @Test
    public void test_02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取 String 类的 length 方法
        Method lengthMethod = String.class.getMethod("length");

        // 调用 length 方法
        String str = "Hello, World!";
        int result = (int) lengthMethod.invoke(str);

        System.out.println("Length of the string: " + result);
    }
}
