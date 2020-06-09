package com.ht.web.student;

import com.ht.service.student.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author lrq
 * @date 2020/6/9 8:51
 * 学生管理
 */
@Controller
@RequestMapping("Student")
public class StuController {
    @Resource
    private StudentService studentService;

    @RequestMapping("list")
    public String list(){
        System.out.println("？？？？？？？");
        return "";
    }
}
