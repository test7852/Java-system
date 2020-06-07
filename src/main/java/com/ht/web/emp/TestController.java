package com.ht.web.emp;

import com.ht.bean.Dept;
import com.ht.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private DeptService deptService;

    @RequestMapping("/test")
    public String go(){
        System.out.println("进来了");
        System.out.println("你们在干嘛！！！！");
        System.out.println("你们坐不住嘛！！！！");
//        根据id删除
        deptService.deleteByPrimaryKey(1);

        return "emp/test";
    }
}
