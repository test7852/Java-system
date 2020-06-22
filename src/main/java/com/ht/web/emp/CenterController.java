package com.ht.web.emp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //去部门列表页面
    @RequestMapping("deplist")
    public String deplist(){
        return "emp/deplist";
    }

    //去到周报管理页面
    @RequestMapping("worklist")
    public String worklist(){
        return "emp/workdiarylist";
    }

    //去到职位管理页面
    @RequestMapping("postlist")
    public String postlist(){
        return "emp/postlist";
    }
    //去到职位添加页面
    @RequestMapping("postadd")
    public String postadd(){
        return "emp/postadd";
    }

    //去到我的周报管理页面
    @RequestMapping("myworklist")
    public String myworklist(){
        return "emp/myworkdiary";
    }

    //去到谈心记录页面
    @RequestMapping("chatlist")
    public String chatlist(){
        return "emp/chatrecordlist";
    }

    //去到首页页面
    @RequestMapping("headerList")
    public String headerList(){
        return "managerui/headerList";
    }

    //去证件上传
    @RequestMapping("voucher")
    public String voucher(Integer id, Model model){
        model.addAttribute("id",id);
        return "emp/voucher";
    }

    //去到系统设置
    @RequestMapping("systemsetting")
    public String systemsetting(){
        return "managerui/systemsetting";
    }
}
