package com.yuan.springmvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    // @RequestMapping注解：处理请求和控制器方法之间的映射关系
    // @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        //return "success";
        return "target";
    }

    @RequestMapping(path="/RequestMappingTest")
    public String goToRequestMapping(){
        System.out.println("Hello SpringMVC");
        //return "success";
        return "RequestMappingTest";
    }

    @RequestMapping(path="/RequestProcessTest")
    public String goToRequestProcess(){
        System.out.println("Hello SpringMVC");
        //return "success";
        return "RequestProcessTest";
    }

    @RequestMapping(path="/ScopeDataTest")
    public String goToScopeDataTest(){
        System.out.println("Hello SpringMVC");
        //return "success";
        return "ScopeDataTest";
    }


}
