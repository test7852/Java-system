package com.ht.web.education;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lrq
 * @date 2020/6/10 19:38
 * 中心跳转
 */
@Controller
@RequestMapping("skip")
public class ECenterController {

    //去到班级成绩管理页面
    @RequestMapping("classscorelist")
    public String modellist(){
        return "education/classscorelist";
    }
    //去到班级答辩管理页面
    @RequestMapping("classreplylist")
    public String replylist(){
        return "education/classreplylist";
    }

}
