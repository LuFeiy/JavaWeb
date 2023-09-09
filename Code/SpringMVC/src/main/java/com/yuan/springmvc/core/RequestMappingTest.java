package com.yuan.springmvc.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
public class RequestMappingTest {

    //此时请求映射所映射的请求的请求路径为：/test/testRequestMapping
    @RequestMapping({"/testRequestMapping","testRequestMapping2"})
    public String testRequestMapping1(){
        return "target";
    }

    //此时请求映射所映射的请求的请求路径为：/test/testRequestMapping
    @RequestMapping(path="testRequestMethod",method = {RequestMethod.GET, RequestMethod.POST})
    public String testRequestMapping2(){
        return "target";
    }

    //此时请求映射所映射的请求的请求路径为：/test/testRequestMapping
    @RequestMapping(path="testRequestParam",params = {"username","password!=123456"})
    public String testRequestMapping3(){
        return "target";
    }


}



/*
* 1. RequestMapping可以加到类上和方法上,Controller类上的注解可以不加,方法上一定要加
*
* 2. @RequestMapping("test")实际上是将"test"隐式的复制给了value属性，value和path又是同一个,所以这里test就是指定了path
* 3. value属性是一个String[] value(),是可以配多个的,例如：@RequestMapping({"/testRequestMapping","test"})
*
* 4. method属性是一个RequestMethod类型的数组，表示该请求映射能够匹配多种请求方式的请求，但是目前浏览器只支持get和post，
*    对于处理指定请求方式的控制器方法，SpringMVC中提供了@RequestMapping的派生注解@GetMapping @PostMapping @PutMapping @DeleteMapping
*    若在form表单提交时，为method设置了其他请求方式的字符串（put或delete），则按照默认的请求方式get处理
*    若要发送put和delete请求，则需要通过spring提供的过滤器HiddenHttpMethodFilter，在RESTful部分会讲到
*
* 5. params属性并不是为了获取请求参数,而是通过请求参数来匹配处理方法,也是一个String[],有多个条件时是与的关系
*
*
* */
