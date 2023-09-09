package _4advanced.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericWrap {

    class G1<T>{
        private T t;
    }

    //在运行时list1和list2 都是java.util.ArrayList
    @Test
    public void test_01(){
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
    }

    public static <T> T add (T a,T b){
        if (a.getClass().equals(String.class) && b.getClass().equals(String.class)){
            return (T) ((String)a + (String)b);
        } else if (a.getClass().equals(Integer.class) && b.getClass().equals(Integer.class)) {
            return (T) (Integer)((Integer)a + (Integer)b);
        }else {
            return null;
        }
    }

    @Test
    public void test_02(){
        System.out.println("a + b :" + add("a","b"));
        System.out.println("1 + 2 :" + add(1,2));
    }


    public static void main(String[] args) {
        System.out.println("a + b :" + add("a","b"));
        System.out.println("1 + 2 :" + add(1,2));
    }
}
