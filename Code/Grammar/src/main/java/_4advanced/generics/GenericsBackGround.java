package _4advanced.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericsBackGround {

    /*
    * 泛型产生的背景
    * */
    @Test
    public void test_01(){
        List list = new ArrayList();
        // 容器中的数据可以随便加,没有约束
        list.add("xxString");
        list.add(100d);
        list.add(new Date());
        System.out.println(list);

        //取出来用的时候需要人为的强制类型转换,很容易报错
        String str = (String)list.get(0);
        String upperCase = str.toUpperCase();
        System.out.println("upperCase: " + upperCase);

        Class<?> objClass = str.getClass();
        System.out.println("对象的类型是：" + objClass.getName());

    }

    //大量的雷同的代码
    public static int add(int a, int b){
        System.out.println("int add(int a, int b)");
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static float add(float a, float b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static double add(double a, double b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    //可以通过下面的方式简化，将上面三个函数定义简化成一个
    public static <T extends Number> double add_t(T a,T b){
        System.out.println("<T extends Number> double add(T a,T b)");
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }


    @Test
    public void test_02(){
        add(1, 2);
        add(1.2, 2);

        add_t(1, 2);
        add_t(1.2, 2);

        add(1, 2);
    }
}
