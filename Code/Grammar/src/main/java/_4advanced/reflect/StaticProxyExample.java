package _4advanced.reflect;

import org.junit.Test;

//接口,定义用户操作
interface UserService {
    void saveUser(String username);
}

// 原始类：实现用户操作
class UserServiceImpl implements UserService {
    @Override
    public void saveUser(String username) {
        System.out.println("Saving user:" + username);
    }
}

//代理类,实现用户操作接口,代理用户操作
class UserServiceProxy implements UserService {
    private UserService userService;

    UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void saveUser(String username) {
        System.out.println("before saving user");
        userService.saveUser(username);
        System.out.println("after saving user");
    }
}


public class StaticProxyExample {

    @Test
    public void test_01() {
        UserService userService = new UserServiceImpl();//原始类对象
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);

        userServiceProxy.saveUser("li yuan");
    }
}
