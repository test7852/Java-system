package com.ht.web.student;

import com.ht.bean.emp.Empinfo;
import com.ht.bean.student.*;
import com.ht.bean.json.JsonData;
import com.ht.service.emp.EmpinfoService;
import com.ht.service.student.*;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
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
    private StudentService studentService;//学生
    @Resource
    private StudentfloorService studentfloorService;//楼栋
    @Resource
    private StudenthuorService studenthuorService;//宿舍
    @Resource
    private StudentclassService studentclassService;//班级
    @Resource
    private EmpinfoService empinfoService;//老师
    @Resource
    private DeptService deptService;//系
    @Resource
    private MajorService majorService;//专业

    //去学生页面
    @RequestMapping("stulistUi")
    public String stulistUi(){
        return"student/stulist";
    }
    //去查看
    @RequestMapping("select")
    public String select(Integer studid,Map map){
        List<Studenthuor> studenthuorList= studenthuorService.selList();//查找学生宿舍
        List<Studentclass> studentclasses= studentclassService.selList();//查找学生班级
        Student student=studentService.selectByPrimaryKey(studid);
        System.out.println("查看："+student.toString());
        map.put("student", student);
        map.put("studentclasses", studentclasses);
        map.put("studenthuorList", studenthuorList);
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
    public String toadd(Map map){
        List<Studentfloor> studentfloorList= studentfloorService.selList();//查找楼栋
        List<Studentclass> studentclasses= studentclassService.selList();//查找学生班级
        List<Dept> deptList= deptService.allDept();//查找系
        map.put("studentfloorList", studentfloorList);
        map.put("studentclasses", studentclasses);
        map.put("deptList", deptList);
        return "student/stuadd";
    }


    @ResponseBody
    @RequestMapping("byhuorid")
    public List byhuorid(int floorId){
        System.out.println("floorid："+floorId);
        List<Studenthuor> l=studenthuorService.selByFid(floorId);
        return l;
    }

    @ResponseBody
    @RequestMapping("bymajorid")
    public List bymajorid(int deptid){
        System.out.println("deptid："+deptid);
        List<Major> l=majorService.byDeptId(deptid);
        return l;
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
    public String add(Student student, HttpSession session){
        Empinfo empinfo=(Empinfo)session.getAttribute("user");
        student.setIntroduretech(String.valueOf(empinfo.getEmp_id()));
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
