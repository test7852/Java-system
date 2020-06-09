package com.ht.web.emp;
import com.ht.bean.emp.Empinfo;
import com.ht.service.emp.EmpinfoService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
/**
 * 员工管理
 *
 * */
@Controller
@RequestMapping("emp")
public class EmpController {
    @Resource
    private EmpinfoService empinfoService;

    /**
     * @param empinfo
     * @return
     * 登录
     */
    @RequestMapping("login")
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

    @RequestMapping("list")
    public String list(Pager pager){
        pager.pageSize = 2;
        //查询总行数
        pager.page(empinfoService.selprocount());
        pager.data = empinfoService.allPageEmp(pager);
        System.out.println(empinfoService.selprocount());
        System.out.println(pager.data.toString());
        return "managerui/index";
    }

    @RequestMapping("/zhuc")
    public String zhuc(){
        return "managerui/register";
    }

    @RequestMapping("/zhuye")
    public String zhuye(){
        return "managerui/index";
    }

    @RequestMapping("/logins")
    public String logins(){
        return "managerui/login";
    }
}
