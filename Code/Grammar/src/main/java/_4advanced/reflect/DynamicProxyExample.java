package _4advanced.reflect;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理处理器
class ProxyHandler implements InvocationHandler {
    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoking method:" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after invoking method:" + method.getName());
        return result;
    }
}

public class DynamicProxyExample {
    @Test
    public void test_01(){
        UserServiceImpl userService = new UserServiceImpl();// 原始类对象

        UserService proxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new ProxyHandler(userService));

        proxy.saveUser("Alice");
    }
}
