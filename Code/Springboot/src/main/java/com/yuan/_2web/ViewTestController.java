package com.yuan._2web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/hellov")
    public String hello(Model model){
        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        System.out.println("wwzzll");
        model.addAttribute("msg","一定要大力发展工业文化");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }

    @GetMapping("/basic_table")
    public String use(Model model){
        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        System.out.println("basic_table");
        return "basic_table";
    }
}
