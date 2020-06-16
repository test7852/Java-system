package com.ht.web.student;

import com.ht.bean.emp.Empinfo;
import com.ht.bean.json.JsonData;
import com.ht.bean.student.*;
import com.ht.service.emp.DepService;
import com.ht.service.emp.EmpinfoService;
import com.ht.service.student.DeptService;
import com.ht.service.student.MajorService;
import com.ht.service.student.StudentclassService;
import com.ht.service.student.StudentfallService;
import com.ht.util.Contants;
import com.ht.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 王钟华
 * @date 2020-06-10 10:53
 */
@Controller
@RequestMapping("studentClass")
public class StudentClassController {

    @Resource
    private JsonData jsonData;
    @Resource
    private StudentclassService studentclassService;
    @Resource
    private EmpinfoService empinfoService;
    @Resource
    private DeptService deptService;
    @Resource
    private MajorService majorService;
    @Resource
    private StudentfallService studentfallService;

    @RequestMapping("data")
    @ResponseBody
    public JsonData data(@Param("limit")int limit , @Param("page")int page){
        Pager pager = new Pager();
        pager.setPageSize(limit);
        pager.setCurrPage(page);
        jsonData.setCount(studentclassService.selCount());
        jsonData.setData(studentclassService.sybase(pager));
        return jsonData;
    }


    /**
     * @return
     * 去班级添加
     */
    @RequestMapping("/toadd")
    public String toadd(Map map) {
        List<Empinfo> lecturers = empinfoService.selByPostId(Contants.POST_CLASS);
        List<Empinfo> classTeachers = empinfoService.selByPostId(Contants.POST_TEACHER);
        List<Dept> depts = deptService.allDept();
        List<Studentfall> studentFalls = studentfallService.selList();
        map.put("studentFalls",studentFalls);
        map.put("lecturers",lecturers);
        map.put("classTeachers",classTeachers);
        map.put("depts",depts);
        return "student/studentClassAdd";
    }

    /**
     * @param studentclass
     * @return
     * 添加班级
     */
    @RequestMapping("add")
    @ResponseBody
    public Integer add(Studentclass studentclass){
        List<Studentclass> list = studentclassService.selList();
        for (Studentclass studentclass1:list) {
            if (studentclass.getClassname().equals(studentclass1.getClassname()) || studentclass1.getClassname()==studentclass.getClassname()
            || studentclass.getClassno().equals(studentclass1.getClassno()) || studentclass1.getClassno()==studentclass.getClassno()){
                return 0;
            }
        }
        Integer i = studentclassService.insertSelective(studentclass);
        return i;
    }

    /**
     * @return
     * 去班级页面
     */
    @RequestMapping("list")
    public String list(){
        return "student/studentClass";
    }





    @RequestMapping("del")
    public String del(@Param("id") Integer id){
        System.out.println("id = " + id);
       studentclassService.deleteByPrimaryKey(id);
        return "redirect:studentClass/list";
    }


    /**
     * @param id
     * @return 根据系id查找所在该系下的专业
     */
    @RequestMapping("byDeptId")
    @ResponseBody
    public List byDeptId(Integer id) {
        List<Major> l  = majorService.byDeptId(id);
        return l;
    }

    /**
     * @param studentclass
     * @return 修改
     */
    @RequestMapping("update")
    @ResponseBody
    public Integer updata(Studentclass studentclass) {
        List<Studentclass> list = studentclassService.selList();
        for (Studentclass studentclass1 : list) {
            if (studentclass.getClassname().equals(studentclass1.getClassname()) || studentclass1.getClassname() == studentclass.getClassname()
                    || studentclass.getClassno().equals(studentclass1.getClassno()) || studentclass1.getClassno() == studentclass.getClassno()) {
                return 0;
            }
        }
        Integer i = studentclassService.updateByPrimaryKeySelective(studentclass);
        return i;
    }
}
