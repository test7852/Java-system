package com.ht.web.emp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lrq
 * @date 2020/6/10 19:38
 * 中心跳转
 */
@Controller
@RequestMapping("skip")
public class CenterController {

    //去登录页面
    @RequestMapping("tologin")
    public String tologin(){
        return "managerui/login";
    }

    //去登录页面
    @RequestMapping("index")
    public String index(){
        return "managerui/index";
    }

    //去员工页面
    @RequestMapping("emplist")
    public String emplist(){
        return "emp/emplist";
    }

}
