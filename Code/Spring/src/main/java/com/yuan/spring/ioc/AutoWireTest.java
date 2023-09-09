package com.yuan.spring.ioc;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Setter
@NoArgsConstructor
class UserController {
    private UserService userService;

    public void saveUser(){
        userService.saveUser();
    }
}

@Setter
@NoArgsConstructor
class UserService {
    private UserDao userDao;

    public void saveUser() {
        userDao.saveUser();
    }
}

@Setter
@NoArgsConstructor
class UserDao{
    public void saveUser() {
        System.out.println("保存成功");
    }
}


public class AutoWireTest {
    @Test
    public void test_01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserController userController = ac.getBean(UserController.class);
        userController.saveUser();
    }
}
