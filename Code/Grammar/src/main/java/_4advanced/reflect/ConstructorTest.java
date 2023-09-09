package _4advanced.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class User {
    private int age;
    private String name;
    public User() {
        super();
    }
    public User(String name) {
        super();
        this.name = name;
    }

    private User(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ConstructorTest {

    @Test
    public void test_01() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = null;

        //获取Class对象引用
        clazz = Class.forName("_4advanced.reflect.User");

        //第一种方法,用默认的构造方法,User必须含有无参构造函数
        User user = (User)clazz.newInstance();
        user.setAge(11);
        user.setName("lan lan");
        System.out.println(user);
        System.out.println("--------------------------------");

        //获取带有String参数的public 构造函数
        Constructor<?> cs1 = clazz.getConstructor(String.class);
        //Constructor<String> cs2 = clazz.getConstructor(String.class); 这里会报错，不理解
        User user1 = (User)cs1.newInstance("zhong lan");
        user1.setAge(22);
        System.out.println(user1);
        System.out.println("--------------------------------");

        //获取带有int和String类型的参数的构造函数,该方法是私有的
        Constructor<?> cs2 = clazz.getDeclaredConstructor(int.class, String.class);
        cs2.setAccessible(true);
        User user2 = (User)cs2.newInstance(24, "yuan");
        System.out.println(user2);
        System.out.println("--------------------------------");

        //获取所有构造函数,包含private
        Constructor<?>[] cons = clazz.getDeclaredConstructors();
        //查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class<?>[] parameterTypes = cons[i].getParameterTypes();
            System.out.println("构造函数["+i+"]:" + cons[i].toString());
            System.out.print("参数类型["+i+"]:(");
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j == parameterTypes.length - 1) {
                    System.out.print(parameterTypes[j].getName());
                }else {
                    System.out.print(parameterTypes[j].getName() + ",");
                }
            }
            System.out.println(")");
        }
    }

}
