package com.ht.web.emp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/test")
    public String go(){
        System.out.println("进来了");
        System.out.println("罗俊进来过");
        return "emp/test";
    }
}
