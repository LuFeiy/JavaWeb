package com.yuan.springmvc.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ScopeDataTest {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("testScope", "hello,servletAPI");
        return "ScopeDataTestResult";
    }
}
