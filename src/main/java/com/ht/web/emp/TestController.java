package com.ht.web.emp;

import com.ht.bean.Empinfo;
import com.ht.service.DeptService;
import com.ht.service.EmpinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Emp")
public class TestController {
    @Resource
    private EmpinfoService empinfoService;
    //登录
    @RequestMapping("/login")
    public String login(Empinfo empinfo){
        empinfo.setPhone("1111111");
        empinfo.setPassword("123456");
        Empinfo user = empinfoService.login(empinfo);
        if (user == null){
            System.out.println("失败");
        }
        System.out.println("成功");
        return "emp/home";
    }
    //注册
    @RequestMapping("/register")
    public String register(Empinfo empinfo){
        empinfo.setEmpName("王钟华");
        empinfo.setPhone("15717978951");
        empinfo.setPassword("123");
        empinfoService.insert(empinfo);
        return "emp/home";
    }

}
