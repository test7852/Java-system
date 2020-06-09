package com.ht.web.student;

import com.ht.bean.student.Student;
import com.ht.service.student.StudentService;
import com.ht.util.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author lrq
 * @date 2020/6/9 8:51
 * 学生管理
 */
@Controller
@RequestMapping("stu")
public class StuController {
    @Resource
    private StudentService studentService;

    @RequestMapping("list")
    public String list(Pager pager, Map map){
        pager.page(studentService.getTotalRow());
        map.put("",studentService.allPageStu(pager));
        return "";
    }

    @RequestMapping("add")
    public String add(Student student){
        studentService.insert(student);
        return "";
    }

    @RequestMapping("upd")
    public String upd(Student student){
        studentService.updateByPrimaryKey(student);
        return "";
    }

    @RequestMapping("del")
    public String del(int stuid){
        studentService.deleteByPrimaryKey(stuid);
        return "";
    }
}
