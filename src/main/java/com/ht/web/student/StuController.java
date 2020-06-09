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

    /**
     * @param pager
     * @param map
     * @return
     * 分页
     */
    @RequestMapping("list")
    public String list(Pager pager, Map map){
        pager.page(studentService.getTotalRow());
        map.put("",studentService.allPageStu(pager));
        return "";
    }

    /**
     * @param student
     * @return
     * 去添加页面
     */
    @RequestMapping("toadd")
    public String toadd(Student student){
        studentService.insert(student);
        return "";
    }

    /**
     * @param student
     * @return
     * 添加学生信息
     */
    @RequestMapping("add")
    public String add(Student student){
        studentService.insert(student);
        return "";
    }

    /**
     * @param stuid
     * @param map
     * @return
     * 去修改页面
     */
    @RequestMapping("toupd")
    public String toupd(int stuid,Map map){
        map.put("",studentService.selectByPrimaryKey(stuid));
        return "";
    }

    /**
     * @param student
     * @return
     * 修改学生信息
     */
    @RequestMapping("upd")
    public String upd(Student student){
        studentService.updateByPrimaryKey(student);
        return "";
    }

    /**
     * @param stuid
     * @return
     * 删除学生
     */
    @RequestMapping("del")
    public String del(int stuid){
        studentService.deleteByPrimaryKey(stuid);
        return "";
    }
}
