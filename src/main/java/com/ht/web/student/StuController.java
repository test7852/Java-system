package com.ht.web.student;

import com.ht.bean.student.Student;
import com.ht.bean.json.JsonData;
import com.ht.service.student.StudentService;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//去学生页面
    @RequestMapping("stulistUi")
    public String stulistUi(){
        return"student/stulist";
    }
//去查看
    @RequestMapping("select")
    public String select(Integer studid,Map map){

        Student student=studentService.selectByPrimaryKey(studid);
        System.out.println("查看："+student.toString());
        map.put("student", student);
        return "student/stusel";
    }
//重置密码
    @RequestMapping("reset")
    @ResponseBody
    public String reset(Integer studid){
        Student student=studentService.selectByPrimaryKey(studid);
        System.out.println("重置前："+student.toString());
        student.setPassword("123456");
        System.out.println("重置后："+student.toString());
        studentService.updateByPrimaryKey(student);
        return "true";
    }
    /**
     * @param
     * @return
     * 去添加页面
     */
    @RequestMapping("toadd")
    public String toadd(){
        return "student/stuadd";
    }

    @Resource
    private JsonData jsonData;
//layui加载数据
    @RequestMapping("studata")
    @ResponseBody
    public JsonData empdata(@Param("limit")int limit , @Param("page")int page ){
        Pager pager=new Pager();
        pager.setCurrPage(page);
        pager.setPageSize(limit);
        jsonData.setCount(studentService.getTotalRow());
        jsonData.setCode(0);
        jsonData.setData(studentService.allPageStu(pager));
        return jsonData;
    }



    /**
     * @param student
     * @return
     * 添加学生信息
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(Student student){
        student.setPassword("123456");
        studentService.insert(student);
        System.out.println("新增："+student.toString());
        return "true";
    }



    /**
     * @param student
     * @return
     * 修改学生信息
     */
    @RequestMapping("upd")
    @ResponseBody
    public String upd(Student student){
        int updatacurr= studentService.updateByPrimaryKey(student);
        System.out.println("修改："+student.toString());
        return "true";
    }

    /**
     * @param studid
     * @return
     * 删除学生
     */
    @RequestMapping("del")
    public String del(int studid){
        System.out.println("删除："+studid);
        studentService.deleteByPrimaryKey(studid);
        return "redirect:stu/stulistUi";
    }
}
