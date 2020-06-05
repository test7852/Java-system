package com.ht.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Test")
public class TestController {
    @RequestMapping("/go")
    public String go(){
        System.out.println("进来了");
        return "aaa";
    }
}
