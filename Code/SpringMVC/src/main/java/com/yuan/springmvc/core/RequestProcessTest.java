package com.yuan.springmvc.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RequestProcessTest {

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "target";
    }

    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "target";
    }

    @RequestMapping("/testpojo")
    public String testPOJO(User user){
        System.out.println(user);
        return "target";
    }
}
